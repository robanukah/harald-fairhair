package com.github.solairerove.harald.domain.service.comment;

import com.github.solairerove.harald.domain.model.Comment;
import com.github.solairerove.harald.domain.model.exception.ResourceNotFoundException;
import com.github.solairerove.harald.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultCommentService implements CommentService {

    private final CommentRepository repository;

    @Override
    public Comment create(final Long id, final Comment comment) {
        log.info("Create comment: {} in post: {}", comment, id);

        comment.setPostId(id);

        return repository.save(comment);
    }

    @Override
    public Comment fetchById(final Long postId, final Long commentId) {
        log.info("Fetch comment: {} from post: {}", commentId, postId);

        return repository.findOneById(postId, commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id: " + commentId
                        + " doesn't exist in post: " + postId));
    }

    @Override
    public List<Comment> fetchAllFromPost(final Long postId) {
        log.info("Fetch all comments from post: {}", postId);

        return repository.findAllByPostId(postId);
    }
}
