package com.github.solairerove.harald.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
@JsonRootName(value = "post")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO implements Serializable {

    private static final long serialVersionUID = 630335968872043885L;

    @JsonProperty
    private final String title;

    @JsonProperty
    private final String author;

    @JsonProperty
    private final String date;

    @JsonProperty
    private final String content;
}
