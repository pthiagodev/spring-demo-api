package com.demorestapi.teste.controller;

import com.demorestapi.teste.model.Usuario;
import com.demorestapi.teste.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;

        usuarioRepository.saveAll(List.of(
                new Usuario("Thiago"),
                new Usuario("Rafael"),
                new Usuario("Alexandre")
        ));
    }

    @GetMapping
    Iterable<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Usuario> getUsuarioById(@PathVariable String id){
        return usuarioRepository.findById(id);
    }

    @PostMapping
    Usuario postUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    ResponseEntity<Usuario> putUsuario(@PathVariable String id,
                                       @RequestBody Usuario usuario) {
        return (usuarioRepository.existsById(id))
                ? new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.OK)
                : new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    void deleteUsuario(@PathVariable String id) {
        usuarioRepository.deleteById(id);
    }
}
