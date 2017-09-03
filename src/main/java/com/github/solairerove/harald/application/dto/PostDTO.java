package com.github.solairerove.harald.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@JsonRootName(value = "post")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO implements Serializable {

    private static final long serialVersionUID = 630335968872043885L;

    @JsonProperty
    private String title;

    @JsonProperty
    private String author;

    @JsonProperty
    private String date;

    @JsonProperty
    private String content;
}
