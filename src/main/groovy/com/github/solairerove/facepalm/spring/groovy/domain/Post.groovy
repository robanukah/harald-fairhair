package com.github.solairerove.facepalm.spring.groovy.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Data
import lombok.NoArgsConstructor
import lombok.experimental.Accessors
import org.springframework.data.domain.Persistable

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "post")
class Post implements Persistable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_id_seq")
    @SequenceGenerator(name = "post_id_seq", sequenceName = "post_id_seq", allocationSize = 1)
    private Integer id

    @NotNull(message = "Title is required!")
    @Column(name = "title", nullable = false)
    private String title

    @Column(name = "author")
    private String author

    @Column(name = "date")
    private String date

    @Column(name = "content")
    private String content

    @JsonIgnore
    @Override
    Integer getId() {
        return id
    }

    @JsonIgnore
    @Override
    boolean isNew() {
        return id == null
    }
}
