package com.github.solairerove.facepalm.domain.model.security;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

public enum AuthorityName {
    ROLE_USER, ROLE_ADMIN;

    /**
     * To retrieve all authorities.
     */
    public static final List<AuthorityName> VALUES = unmodifiableList(asList(values()));
}
