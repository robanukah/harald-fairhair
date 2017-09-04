package com.github.solairerove.harald.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "post")
@NoArgsConstructor
public class Post implements Persistable<Long> {

    private static final long serialVersionUID = -1229358169012104747L;

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "post_generator", sequenceName = "post_sequence", allocationSize = 1)
    @GeneratedValue(generator = "post_generator", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull(message = "Title is required!")
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "date")
    private String date;

    @Column(name = "content")
    private String content;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }
}
