package com.rustcompany.app.order_demo_project.security;

public enum Permission {
    ORDERS_POST("orders:post"),
    ORDERS_READ_EDIT("orders:read_edit");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
