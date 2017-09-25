package com.github.solairerove.harald.application.dto.post;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.solairerove.harald.application.dto.comment.CommentResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostResponse implements Serializable {

    private static final long serialVersionUID = 8221818444202026540L;

    @JsonProperty
    private Long id;

    @JsonProperty
    private String title;

    @JsonProperty
    private String author;

    @JsonProperty
    private String date;

    @JsonProperty
    private String content;

    @JsonProperty
    private List<CommentResponse> comments;
}
