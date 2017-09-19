package com.github.solairerove.harald.domain.service.post;

import com.github.solairerove.harald.domain.model.Post;
import com.github.solairerove.harald.domain.model.exception.ResourceNotFoundException;
import com.github.solairerove.harald.domain.repository.PostRepository;
import com.github.solairerove.harald.domain.service.post.PostService;
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
public class PostServiceTest {

    private static final Long NON_EXISTS_ID = 100L;

    private Post post;

    private Long id;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @Before
    public void setUp() {
        postRepository.deleteAll();

        post = new Post();
        post.setTitle("Some awesome title");
        post.setAuthor("solairerove");
        post.setDate("26-04-1986");
        post.setContent("My Content");

        id = postRepository.save(post).getId();
    }

    @Test
    public void createTest_expect_success() {
        final String content = "One more saved post";
        post.setContent(content);

        final Post saved = postService.create(post);

        assertThat(saved.getContent(), Is.is(content));
    }

    @Test
    public void fetchByIdTest_expect_success() {
        final Post fetched = postService.fetchById(id);

        assertThat(fetched.getContent(), Is.is(post.getContent()));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void fetchByIdTest_withIncorrectId_expect_ResourceNotFound() {
        postService.fetchById(NON_EXISTS_ID);
    }

    @Test
    public void updateByIdTest_assertUpdatedField_expect_success() {
        final String title = "Some updated awesome title";

        final Post updated = new Post();
        updated.setTitle(title);

        postService.updateById(id, updated);

        assertThat(postRepository.findOne(id).getTitle(), Is.is(title));
    }

    @Test
    public void updateByIdTest_assertNonUpdatedField_expect_success() {
        final String title = "Some updated awesome title";

        final Post updated = new Post();
        updated.setTitle(title);

        postService.updateById(id, updated);

        assertThat(postRepository.findOne(id).getContent(), Is.is(post.getContent()));
    }

    @Test
    public void deleteByIdTest_assertPost_expect_success() {
        final Post deleted = postService.deleteById(id);

        assertThat(deleted.getContent(), Is.is(post.getContent()));
    }

    @Test
    public void deleteByIdTest_assertCount_expect_success() {
        postService.deleteById(id);

        assertThat(postRepository.count(), Is.is(0L));
    }
}
