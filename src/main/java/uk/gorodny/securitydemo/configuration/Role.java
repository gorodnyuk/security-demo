package uk.gorodny.securitydemo.configuration;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN("ADMIN"),
    USER("USER");

    Role(String value) {
        this.value = value;
    }

    private String value;

    @Override
    public String getAuthority() {
        return value;
    }
}
