package com.github.solairerove.harald.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.domain.Persistable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(exclude = {"comments"})
@ToString(exclude = {"comments"})
@Entity
@Table(name = "post")
public class Post implements Persistable<Long> {

    private static final long serialVersionUID = -1229358169012104747L;

    @Id
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    @SequenceGenerator(name = "post_generator", sequenceName = "post_sequence", initialValue = 3, allocationSize = 1)
    @GeneratedValue(generator = "post_generator", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull(message = "Title is required!")
    @Column(name = "title", nullable = false, length = 128)
    private String title;

    @Column(name = "author", length = 32)
    private String author;

    @Column(name = "date", length = 32)
    private String date;

    @Column(name = "content")
    private String content;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false, insertable = false,  updatable = false)
    private List<Comment> comments = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return Objects.nonNull(id);
    }
}
