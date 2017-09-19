package com.github.solairerove.harald.domain.service.comment;

import com.github.solairerove.harald.domain.model.Comment;

import java.util.List;

/**
 * Comment service.
 */
public interface CommentService {

    /**
     * Create comment due {@link Comment} entity.
     *
     * @param postId  a post id
     * @param comment a {@link Comment} entity
     * @return created entity
     */
    Comment create(Long postId, Comment comment);

    /**
     * Fetch {@link Comment} entity by id.
     *
     * @param postId    a {@link Long} post id
     * @param commentId a {@link Long} comment id
     * @return {@link Comment} entity by id
     */
    Comment fetchById(Long postId, Long commentId);

    /**
     * Fetch all {@link Comment} entities from post by id.
     *
     * @return {@link Comment} collection
     */
    List<Comment> fetchAllFromPost(Long postId);
}
