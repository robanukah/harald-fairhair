package com.github.solairerove.harald.domain.service.comment;

import com.github.solairerove.harald.domain.model.Comment;

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
     * @param id a {@link Long} id
     * @return {@link Comment} entity by id
     */
    Comment fetchById(Long id);
}
