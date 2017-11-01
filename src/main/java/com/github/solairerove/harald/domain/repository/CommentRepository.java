package com.github.solairerove.harald.domain.repository;

import com.github.solairerove.harald.domain.model.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM comment WHERE post_id = ?1 and id = ?2", nativeQuery = true)
    Comment findOneById(Long postId, Long commentId);

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM comment WHERE post_id = ?1", nativeQuery = true)
    List<Comment> findAllByPostId(Long postId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE post SET " +
            "title = COALESCE(?2, title), " +
            "author = COALESCE(?3, author), " +
            "date = COALESCE(?4, date), " +
            "content = COALESCE(CAST(?5 AS TEXT), content) " +
            "WHERE id = ?1", nativeQuery = true)
    void updateOneById(Long id, String title, String author, String date, String content);
}
