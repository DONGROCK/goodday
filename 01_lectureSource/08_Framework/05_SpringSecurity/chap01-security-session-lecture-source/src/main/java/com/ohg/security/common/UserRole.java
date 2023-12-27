package com.ohg.security.common;

public enum UserRole {

    USER("USER"),
    ADMIN("ADMIN");

    private String role;

    UserRole(String role) { this.role = role;}

    public String getRole() { return role; }

    @Override
    public String toString() {
        return super.toString();
    }
}
