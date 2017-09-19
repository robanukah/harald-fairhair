package com.github.solairerove.harald.domain.repository;

import com.github.solairerove.harald.domain.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM comment WHERE post_id = ?1 and id = ?2", nativeQuery = true)
    Optional<Comment> findOneById(Long postId, Long commentId);

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM comment WHERE post_id = ?1", nativeQuery = true)
    List<Comment> findAllByPostId(Long postId);
}
