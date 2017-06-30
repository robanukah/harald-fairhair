package com.github.solairerove.facepalm.security.authentication;

import org.springframework.security.core.Authentication;

/**
 * Simple facade to retrieve authentication.
 */
public interface AuthenticationFacade {

    /**
     * Retrieve the auth everywhere
     *
     * @return current context auth
     */
    Authentication getAuthentication();
}
