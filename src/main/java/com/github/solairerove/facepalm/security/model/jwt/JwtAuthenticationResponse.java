package com.github.solairerove.facepalm.security.model.jwt;

import lombok.Value;

import java.io.Serializable;

@Value
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 2126282760485476740L;

    private String token;
}
