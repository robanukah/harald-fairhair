package com.github.solairerove.harald.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.solairerove.harald.application.dto.PostDTO;
import com.github.solairerove.harald.domain.model.Post;
import com.github.solairerove.harald.domain.repository.PostRepository;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostControllerIT {

    private final static Long NON_EXISTS_ID = 100L;

    private Post post;
    private Long id;
    private PostDTO postDTO;

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webAppConfiguration;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        postRepository.deleteAll();

        post = new Post();
        post.setTitle("some title");
        post.setAuthor("solairerove");
        post.setDate("01.01.1111");
        post.setContent("awesome");
        id = postRepository.save(post).getId();

        postDTO = new PostDTO();
        postDTO.setTitle("dto title");
        postDTO.setAuthor("dto author");
        postDTO.setDate("dto date");
        postDTO.setContent("dto content");

        mvc = MockMvcBuilders
                .webAppContextSetup(webAppConfiguration)
                .build();
    }

    @Test
    public void getByIdTest_withExistsId_expect_success() throws Exception {
        mvc.perform(request(GET, "/api/v1/posts/" + id)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.post.title", is(post.getTitle())))
                .andExpect(jsonPath("$.post.author", is(post.getAuthor())));
    }

    @Test
    public void getByIdTest_withNonExistsId_expect_error() throws Exception {
        mvc.perform(request(GET, "/api/v1/posts/" + NON_EXISTS_ID)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Post with id: " + NON_EXISTS_ID + " doesn't exist")));
    }

    @Test
    public void findAllTest_expect_success() throws Exception {
        final Post newPost = new Post();
        newPost.setTitle("new title");
        postRepository.save(newPost);

        mvc.perform(request(GET, "/api/v1/posts/")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.posts", hasSize(2)))
                .andExpect(jsonPath("$.posts.[0].post.title", is(post.getTitle())))
                .andExpect(jsonPath("$.posts.[1].post.id", Is.isA(Integer.class)))
                .andExpect(jsonPath("$.posts.[1].post.title", is(newPost.getTitle())));
    }

    @Test
    public void createTest_with_normal_postDTO_expect_success() throws Exception {
        mvc.perform(request(POST, "/api/v1/posts/")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsBytes(postDTO)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.post.id", isA(Integer.class)))
                .andExpect(jsonPath("$.post.title", is(postDTO.getTitle())))
                .andExpect(jsonPath("$.post.author", is(postDTO.getAuthor())));
    }

//    @Test
//    public void updateTest_with_normal_postDTO_expect_success() throws Exception {
//        mvc.perform(request(PUT, "/api/v1/posts/" + id)
//                .accept(APPLICATION_JSON_UTF8_VALUE)
//                .contentType(APPLICATION_JSON_UTF8_VALUE)
//                .content(objectMapper.writeValueAsBytes(postDTO)))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.post.id", is(id.intValue())))
//                .andExpect(jsonPath("$.post.title", is(postDTO.getTitle())))
//                .andExpect(jsonPath("$.post.author", is(postDTO.getAuthor())));
//    }

    @Test
    public void updateTest_withNonExistsId_expect_error() throws Exception {
        mvc.perform(request(PUT, "/api/v1/posts/" + NON_EXISTS_ID)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsBytes(postDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Post with id: " + NON_EXISTS_ID + " doesn't exist")));
    }

    @Test
    public void deleteByIdTest_withExistsId_expect_success() throws Exception {
        mvc.perform(request(DELETE, "/api/v1/posts/" + id)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.post.title", is(post.getTitle())))
                .andExpect(jsonPath("$.post.author", is(post.getAuthor())));

        assertThat(0L, is(postRepository.count()));
    }

    @Test
    public void deleteByIdTest_withNonExistsId_expect_error() throws Exception {
        mvc.perform(request(DELETE, "/api/v1/posts/" + NON_EXISTS_ID)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Post with id: " + NON_EXISTS_ID + " doesn't exist")));
    }
}
