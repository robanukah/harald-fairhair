package com.github.solairerove.harald.application.controller;

import com.github.solairerove.harald.application.dto.PostDTO;
import com.github.solairerove.harald.domain.model.Post;
import com.github.solairerove.harald.domain.service.PostService;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/api/v1/posts", produces = APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PostController {

    private final DozerBeanMapper mapper;
    private final PostService postService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable(name = "id") final Long id) {
        final Post post = postService.fetchById(id);

        final PostDTO response = mapper.map(post, PostDTO.class);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody final PostDTO postDTO) {
        final Post request = mapper.map(postDTO, Post.class);

        final Post createdPost = postService.create(request);

        final PostDTO response = mapper.map(createdPost, PostDTO.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
