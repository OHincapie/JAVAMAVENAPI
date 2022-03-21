package com.prueba.prueba.dao;

import com.prueba.prueba.models.Usuario;


import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();
    void eliminar(Long id);
    void createUser(Usuario usuario);

    boolean loginVerify(Usuario usuario);
}
