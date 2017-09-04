package com.github.solairerove.harald.domain.service;

import com.github.solairerove.harald.domain.model.Post;
import com.github.solairerove.harald.domain.model.exception.ResourceNotFoundException;
import com.github.solairerove.harald.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultPostService implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post create(final Post post) {
        log.info("Create post: {}", post);

        return postRepository.save(post);
    }

    @Override
    public Post fetchById(final Long id) {
        log.info("Fetch post by id: {}", id);

        return postRepository.findOneById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id: " + id + " doesn't exist"));
    }
}
