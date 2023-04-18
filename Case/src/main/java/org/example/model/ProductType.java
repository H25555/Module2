package org.example.model;

public enum ProductType {
    COFFEE("coffee"), TEA("tea"), JUICE("juice");

    private final String value;

    ProductType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean fromValue(String value) {
        ProductType[] values = values();
        for (ProductType type : values) {
            if (type.value.equals(value))
                return true;
        }
        return false;
    }
}
