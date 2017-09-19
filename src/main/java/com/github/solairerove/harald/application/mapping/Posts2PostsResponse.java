package com.github.solairerove.harald.application.mapping;

import com.github.solairerove.harald.application.dto.post.PostResponse;
import com.github.solairerove.harald.application.dto.post.PostsResponse;
import com.github.solairerove.harald.domain.model.Post;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;

import java.util.List;

import static org.dozer.loader.api.FieldsMappingOptions.hintA;
import static org.dozer.loader.api.FieldsMappingOptions.hintB;

/**
 * Mapping rules for List of posts to post dto list.
 */
public class Posts2PostsResponse extends BeanMappingBuilder {

    @Override
    protected void configure() {
        mapping(List.class, PostsResponse.class, TypeMappingOptions.oneWay())
                .fields(this_(), "posts",
                        hintA(Post.class),
                        hintB(PostResponse.class));
    }
}
