package com.github.solairerove.harald.domain.service.comment;

import com.github.solairerove.harald.domain.model.Comment;
import com.github.solairerove.harald.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultCommentService implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Comment create(final Long id, final Comment comment) {
        comment.setPostId(id);

        return commentRepository.save(comment);
    }

    @Override
    public Comment fetchById(final Long id) {
        return null;
    }
}
