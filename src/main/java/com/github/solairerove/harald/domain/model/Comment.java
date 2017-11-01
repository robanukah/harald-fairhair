package com.github.solairerove.harald.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.domain.Persistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "comment")
public class Comment implements Persistable<Long> {

    private static final long serialVersionUID = -9033523910520751629L;

    @Id
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    @SequenceGenerator(name = "comment_generator", sequenceName = "comment_sequence", initialValue = 4, allocationSize = 1)
    @GeneratedValue(generator = "comment_generator", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "author", length = 32)
    private String author;

    @Column(name = "date", length = 32)
    private String date;

    @Column(name = "content")
    private String content;

    @Column(name = "post_id")
    private Long postId;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return Objects.nonNull(id);
    }
}
