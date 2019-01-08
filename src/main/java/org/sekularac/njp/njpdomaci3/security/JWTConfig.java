package org.sekularac.njp.njpdomaci3.security;

public class JWTConfig {
    public static final long EXPIRATION_TIME = 864000000;
    public static final String SECRET_KEY = "TAJNICA";
    public static final String AUTH_HEADER = "Authorization";
    public static final String AUTH_TOKEN_TYPE = "Bearer ";
}
