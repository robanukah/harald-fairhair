package com.github.solairerove.harald.domain.repository;

import com.github.solairerove.harald.domain.model.Post;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PostRepositoryTest {

    private static final Long NON_EXISTS_ID = 100L;

    private Post post;

    private Long id;

    @Autowired
    private PostRepository postRepository;

    @Before
    public void setUp() {
        postRepository.deleteAll();

        post = new Post();
        post.setTitle("Some awesome title");
        post.setAuthor("solairerove");
        post.setDate("03.07.1996");
        post.setContent("My Content");

        id = postRepository.save(post).getId();
    }

    @Test
    public void findOneByIdTest_expect_success() {
        final Post saved = postRepository.findOneById(id);

        assertThat(saved.getContent(), Is.is(post.getContent()));
    }

    @Test
    public void findOneByIdTest_withNonExistsId() {
        final Post saved = postRepository.findOneById(NON_EXISTS_ID);

        assertThat(saved, IsNull.nullValue(Post.class));
    }

    @Test
    public void updateOneByIdTest_updateField_expect_success() {
        final String updateAuthor = "Update author";

        final Post saved = postRepository.findOne(id);
        saved.setAuthor(updateAuthor);

        postRepository.updateOneById(id,
                saved.getTitle(),
                saved.getAuthor(),
                saved.getDate(),
                saved.getContent());

        assertThat(postRepository.findOne(id).getAuthor(), Is.is(updateAuthor));
    }

    @Test
    public void updateOneByIdTest_withoutUpdate_expect_success() {
        final Post saved = postRepository.findOne(id);

        postRepository.updateOneById(id,
                saved.getTitle(),
                saved.getAuthor(),
                saved.getDate(),
                saved.getContent());

        assertThat(postRepository.findOne(id).getAuthor(), Is.is(saved.getAuthor()));
    }

    @Test
    public void updateOneByIdTest_withNullField_expect_success() {
        final Post saved = postRepository.findOne(id);

        postRepository.updateOneById(id,
                saved.getTitle(),
                null,
                saved.getDate(),
                saved.getContent());

        assertThat(postRepository.findOne(id).getAuthor(), Is.is(saved.getAuthor()));
    }

    @Test
    public void updateOneByIdTest_withNullFields_expect_success() {
        final Post saved = postRepository.findOne(id);

        postRepository.updateOneById(id, null, null, null, null);

        assertThat(postRepository.findOne(id).getAuthor(), Is.is(saved.getAuthor()));
    }
}
