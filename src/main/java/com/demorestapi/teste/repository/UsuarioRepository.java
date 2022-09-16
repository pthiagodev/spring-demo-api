package com.demorestapi.teste.repository;

import com.demorestapi.teste.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
}
