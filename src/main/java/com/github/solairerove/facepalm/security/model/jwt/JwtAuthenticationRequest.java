package com.github.solairerove.facepalm.security.model.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = 9159462074630329321L;

    private String username;
    private String password;
}
