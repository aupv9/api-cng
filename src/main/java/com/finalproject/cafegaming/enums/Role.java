package com.finalproject.cafegaming.enums;

public enum Role {
    Admin("ROLE_ADMIN"),
    Member("ROLE_MEMBER"),
    Partner("ROLE_PARTNER");

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;
}
