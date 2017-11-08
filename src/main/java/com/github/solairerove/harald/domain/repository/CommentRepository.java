package com.github.solairerove.harald.domain.repository;

import com.github.solairerove.harald.domain.model.Comment;
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
}
