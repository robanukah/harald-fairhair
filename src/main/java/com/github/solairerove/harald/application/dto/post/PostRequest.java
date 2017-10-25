package com.github.solairerove.harald.application.dto.post;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonTypeName(value = "post")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class PostRequest implements Serializable {

    private static final long serialVersionUID = 8199906241190175685L;

    @JsonProperty
    private String title;

    @JsonProperty
    private String author;

    @JsonProperty
    private String date;

    @JsonProperty
    private String content;
}
