package com.github.solairerove.harald.domain.repository;

import com.github.solairerove.harald.domain.model.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT comment.* FROM post " +
            "INNER JOIN comment ON post.id = ?1 AND comment.id = ?2 " +
            "WHERE comment.post_id = post.id", nativeQuery = true)
    Comment findOneById(Long postId, Long commentId);

    @Transactional(readOnly = true)
    @Query(value = "SELECT comment.* FROM post " +
            "INNER JOIN comment ON post.id = ?1 " +
            "WHERE comment.post_id = post.id", nativeQuery = true)
    List<Comment> findAllByPostId(Long postId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE comment SET " +
            "author = COALESCE(?2, author), " +
            "date = COALESCE(?3, author), " +
            "content = COALESCE(CAST(?5 AS TEXT), content) " +
            "WHERE id = ?1", nativeQuery = true)
    void updateOneById(Long postId, Long commentId, String author, String date, String content);
}
