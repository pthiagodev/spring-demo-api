package com.demorestapi.teste.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Usuario {
    @Id
    private String id;
    private String name;

    public Usuario(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Usuario(String name) {
        this(UUID.randomUUID().toString(), name);
    }

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
