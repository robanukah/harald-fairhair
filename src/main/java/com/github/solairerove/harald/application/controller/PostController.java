package com.github.solairerove.harald.application.controller;

import com.github.solairerove.harald.application.dto.PostDTO;
import com.github.solairerove.harald.domain.model.Post;
import com.github.solairerove.harald.domain.service.PostService;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/api/v1/posts", produces = APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PostController {

    private final DozerBeanMapper mapper;
    private final PostService postService;

    @RequestMapping(path = "/{id}")
    public ResponseEntity get(@PathVariable(name = "id") final Long id) {
        final Post post = postService.fetchById(id);

        final PostDTO postDTO = mapper.map(post, PostDTO.class);

        return ResponseEntity.ok().body(postDTO);
    }
}
