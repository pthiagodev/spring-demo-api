package com.demorestapi.teste.controller;

import com.demorestapi.teste.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioController() {
        usuarios.addAll(List.of(
                new Usuario("Thiago"),
                new Usuario("Rafael"),
                new Usuario("Alexandre")
        ));
    }

    @GetMapping
    Iterable<Usuario> getUsuarios(){
        return usuarios;
    }

    @GetMapping("/{id}")
    Optional<Usuario> getUsuarioById(@PathVariable String id){
        for (Usuario u: usuarios) {
            if (u.getId().equals(id)) {
                return Optional.of(u);
            }
        }

        return Optional.empty();
    }

    @PostMapping
    Usuario postUsuario(@RequestBody Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    @PutMapping("/{id}")
    Usuario putUsuario(@PathVariable String id, @RequestBody Usuario usuario) {
        int usuarioIndex = -1;

        for (Usuario u: usuarios) {
            if (u.getId().equals(id)) {
                usuarioIndex = usuarios.indexOf(u);
                usuarios.set(usuarioIndex, usuario);
            }
        }

        return (usuarioIndex == -1) ? postUsuario(usuario) : usuario;
    }

    @DeleteMapping("/{id}")
    void deleteUsuario(@PathVariable String id) {
        usuarios.removeIf(u -> u.getId().equals(id));
    }
}
