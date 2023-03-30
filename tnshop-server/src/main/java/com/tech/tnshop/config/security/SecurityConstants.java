package com.tech.tnshop.config.security;

public class SecurityConstants {
    public static final Long EXPIRATION_TIME = 31536000000L; // 15 mins
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/services/controller/user";
}
