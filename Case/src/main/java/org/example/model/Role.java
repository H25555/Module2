package org.example.model;

public enum Role {
    ADMIN("admin"), EMPLOYEE("employee");

    private final String value;

    Role(String value) {
        this.value = value;
    }
    public static boolean fromValue(String value) {
        Role[] values = values();
        for (Role type : values) {
            if (type.value.equals(value))
                return true;
        }
        return false;
    }
}
