package com.github.solairerove.harald.domain.service.comment;

import com.github.solairerove.harald.domain.model.Comment;
import com.github.solairerove.harald.domain.model.Post;
import com.github.solairerove.harald.domain.repository.CommentRepository;
import com.github.solairerove.harald.domain.repository.PostRepository;
import com.github.solairerove.harald.domain.service.comment.CommentService;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

    private static final Long NON_EXISTS_ID = 100L;

    private Post post;
    private Long postId;
    private Comment comment;
    private Long commentId;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentService commentService;

    @Before
    public void setUp() {
        postRepository.deleteAll();
        commentRepository.deleteAll();

        post = new Post();
        post.setTitle("Some awesome title");
        post.setAuthor("solairerove");
        post.setDate("26-04-1986");
        post.setContent("My Commented content");

        postId = postRepository.save(post).getId();

        comment = new Comment();
        comment.setAuthor("limon");
        comment.setDate("03.04.2017");
        comment.setContent("My comment");
    }

    @Test
    public void createTest_assertContent_expect_success() {
        final Comment saved = commentService.create(postId, comment);

        assertThat(saved.getContent(), Is.is(comment.getContent()));
    }

    @Test
    public void createTest_assertPostId_expect_success() {
        final Comment saved = commentService.create(postId, comment);

        assertThat(saved.getPostId(), Is.is(postId));
    }

    @Test
    public void createTest_assertComment_expect_success() {
        final Comment saved = commentService.create(postId, comment);

        assertThat(saved.getPostId(), Is.is(commentRepository.findAll().iterator().next().getPostId()));
    }
}
