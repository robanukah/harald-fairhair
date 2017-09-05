package com.github.solairerove.harald.domain.service;

import com.github.solairerove.harald.domain.model.Post;

/**
 * Post service.
 */
public interface PostService {

    /**
     * Create post due {@link Post} entity.
     *
     * @param post a {@link Post} entity
     * @return created entity
     */
    Post create(Post post);

    /**
     * Fetch {@link Post} entity by id.
     *
     * @param id a {@link Long} id
     * @return {@link Post} entity by id
     */
    Post fetchById(Long id);

    /**
     * Update {@link Post} entity by id.
     *
     * @param id   a {@link Long} id
     * @param post a {@link Post} entity
     * @return updated {@link Post} entity
     */
    Post updateById(Long id, Post post);
}
