package com.github.solairerove.harald.domain.service.post;

import com.github.solairerove.harald.domain.model.Post;
import com.github.solairerove.harald.domain.model.exception.ResourceNotFoundException;
import com.github.solairerove.harald.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
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

    @Override
    public List<Post> fetchAll() {
        log.info("Fetch all posts");

        return postRepository.findAll();
    }

    @Override
    public Post updateById(Long id, Post post) {
        log.info("Update post: {} by id: {}", post, id);

        final Post saved = fetchById(id);

        postRepository.updateOneById(id,
                Objects.isNull(post.getTitle()) ? saved.getTitle() : post.getTitle(),
                Objects.isNull(post.getAuthor()) ? saved.getAuthor() : post.getAuthor(),
                Objects.isNull(post.getDate()) ? saved.getDate() : post.getDate(),
                Objects.isNull(post.getContent()) ? saved.getContent() : post.getContent()
        );

        return fetchById(id);
    }

    @Override
    public Post deleteById(Long id) {
        log.info("Delete post by id: {}", id);

        final Post deleted = fetchById(id);

        postRepository.deletePostById(id);

        return deleted;
    }
}
