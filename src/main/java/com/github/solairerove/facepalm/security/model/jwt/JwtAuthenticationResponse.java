package com.github.solairerove.facepalm.security.model.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 2126282760485476740L;

    private String token;
}
