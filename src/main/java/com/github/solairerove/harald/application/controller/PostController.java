package com.github.solairerove.harald.application.controller;

import com.github.solairerove.harald.application.dto.PostDTO;
import com.github.solairerove.harald.application.dto.post.PostsResponse;
import com.github.solairerove.harald.domain.model.Post;
import com.github.solairerove.harald.domain.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/api/v1/posts", produces = APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PostController {

    private final DozerBeanMapper mapper;
    private final PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() {
        final List<Post> posts = postService.fetchAll();

        final PostsResponse response = mapper.map(posts, PostsResponse.class);

        return ResponseEntity.status(OK).body(response);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable(name = "id") final Long id) {
        final Post post = postService.fetchById(id);

        final PostDTO response = mapper.map(post, PostDTO.class);

        return ResponseEntity.status(OK).body(response);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody final PostDTO postDTO) {
        final Post request = mapper.map(postDTO, Post.class);

        final Post createdPost = postService.create(request);

        final PostDTO response = mapper.map(createdPost, PostDTO.class);

        return ResponseEntity.status(CREATED).body(response);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable(name = "id") final Long id,
                                 @RequestBody final PostDTO postDTO) {

        final Post request = mapper.map(postDTO, Post.class);

        final Post updatedPost = postService.updateById(id, request);

        final PostDTO response = mapper.map(updatedPost, PostDTO.class);

        return ResponseEntity.status(OK).body(response);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(name = "id") final Long id) {

        final Post deleted = postService.deleteById(id);

        final PostDTO response = mapper.map(deleted, PostDTO.class);

        return ResponseEntity.status(OK).body(response);
    }
}
