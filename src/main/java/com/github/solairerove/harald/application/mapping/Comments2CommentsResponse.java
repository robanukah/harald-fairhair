package com.github.solairerove.harald.application.mapping;

import com.github.solairerove.harald.application.dto.comment.CommentResponse;
import com.github.solairerove.harald.application.dto.comment.CommentsResponse;
import com.github.solairerove.harald.domain.model.Comment;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;

import java.util.List;

import static org.dozer.loader.api.FieldsMappingOptions.hintA;
import static org.dozer.loader.api.FieldsMappingOptions.hintB;

/**
 * Mapping rules for List of comments to comments response list.
 */
public class Comments2CommentsResponse extends BeanMappingBuilder {

    @Override
    protected void configure() {
        mapping(List.class, CommentsResponse.class, TypeMappingOptions.oneWay())
                .fields(this_(), "comments",
                        hintA(Comment.class),
                        hintB(CommentResponse.class));
    }
}
