package com.github.solairerove.harald.application.dto.post;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostsResponse implements Serializable {

    private static final long serialVersionUID = -4133671644550595228L;

    @JsonProperty
    private List<PostResponse> posts;
}
