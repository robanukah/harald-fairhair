package com.github.solairerove.harald.application.dto.comment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonTypeName(value = "comment")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class CommentRequest implements Serializable {

    private static final long serialVersionUID = 5842261256762549186L;

    @JsonProperty
    private String author;

    @JsonProperty
    private String date;

    @JsonProperty
    private String content;
}
