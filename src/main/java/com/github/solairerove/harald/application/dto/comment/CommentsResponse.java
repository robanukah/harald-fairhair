package com.github.solairerove.harald.application.dto.comment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentsResponse implements Serializable {

    private static final long serialVersionUID = 8964579204407147330L;

    @JsonProperty
    private List<CommentResponse> comments;
}
