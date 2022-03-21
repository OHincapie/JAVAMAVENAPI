package com.prueba.prueba.controllers;

import com.prueba.prueba.dao.UsuarioDao;
import com.prueba.prueba.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin("*")
@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario= new Usuario();
        usuario.setId(id);
        usuario.setNombre("David");
        usuario.setApellido("Hincapie");
        usuario.setEmail("nn");
        usuario.setTelefono("911");
        usuario.setPassword("Messi");
        return usuario;
    }


    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }


    @RequestMapping(value = "api/usuario", method = RequestMethod.POST)
    public void createUsuarios(@RequestBody Usuario usuario){
        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash=argon2.hash(1, 1024, 1,usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.createUser(usuario);
    }

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.DELETE)
    public void deleteUsuario(@PathVariable Long id){
        usuarioDao.eliminar(id);
    }


}
