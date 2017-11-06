package com.github.solairerove.harald.application.dto.post;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
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
