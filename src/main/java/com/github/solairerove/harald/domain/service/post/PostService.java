package com.github.solairerove.harald.domain.service.post;

import com.github.solairerove.harald.domain.model.Post;

import java.util.List;

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
     * Fetch all {@link Post} entities.
     *
     * @return {@link Post} collection
     */
    List<Post> fetchAll();

    /**
     * Update {@link Post} entity by id.
     *
     * @param id   a {@link Long} id
     * @param post a {@link Post} entity
     * @return updated {@link Post} entity
     */
    Post updateById(Long id, Post post);

    /**
     * Delete {@link Post} entity by id.
     *
     * @param id a {@link Long} id
     * @return deleted {@link Post} entity
     */
    Post deleteById(Long id);
}
