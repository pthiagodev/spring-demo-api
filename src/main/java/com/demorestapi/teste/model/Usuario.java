package com.demorestapi.teste.model;

import java.util.UUID;

public class Usuario {
    private final String id;
    private String name;

    public Usuario(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Usuario(String name) {
        this(UUID.randomUUID().toString(), name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
