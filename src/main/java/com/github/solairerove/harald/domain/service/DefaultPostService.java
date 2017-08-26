package com.github.solairerove.harald.domain.service;

import com.github.solairerove.harald.domain.model.Post;
import com.github.solairerove.harald.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultPostService implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post create(final Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post fetchById(final Integer id) {
        return postRepository.findOne(id);
    }
}
