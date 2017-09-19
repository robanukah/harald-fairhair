package com.github.solairerove.harald.application.controller;

import com.github.solairerove.harald.application.dto.comment.CommentRequest;
import com.github.solairerove.harald.application.dto.comment.CommentResponse;
import com.github.solairerove.harald.application.dto.comment.CommentsResponse;
import com.github.solairerove.harald.domain.model.Comment;
import com.github.solairerove.harald.domain.service.comment.CommentService;
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
@RequestMapping(value = "/api/v1/posts/{postId}/comments", produces = APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CommentController {

    private final DozerBeanMapper mapper;
    private final CommentService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllFromPost(@PathVariable(name = "postId") final Long postId) {
        final List<Comment> comments = service.fetchAllFromPost(postId);

        final CommentsResponse response = mapper.map(comments, CommentsResponse.class);

        return ResponseEntity.status(OK).body(response);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable(name = "postId") final Long postId,
                                  @PathVariable(name = "id") final Long commentId) {
        final Comment comment = service.fetchById(postId, commentId);

        final CommentResponse response = mapper.map(comment, CommentResponse.class);

        return ResponseEntity.status(OK).body(response);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@PathVariable(name = "postId") final Long postId,
                                 @RequestBody final CommentRequest commentRequest) {
        final Comment request = mapper.map(commentRequest, Comment.class);

        final Comment createdComment = service.create(postId, request);

        final CommentResponse response = mapper.map(createdComment, CommentResponse.class);

        return ResponseEntity.status(CREATED).body(response);
    }
}
