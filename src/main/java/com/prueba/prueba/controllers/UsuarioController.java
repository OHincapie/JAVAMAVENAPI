package com.prueba.prueba.controllers;

import com.prueba.prueba.models.Usuario;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UsuarioController {

    @CrossOrigin(origins = "http://localhost:4200")
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


    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios= new ArrayList<>();
        Usuario usuario= new Usuario();
        usuario.setId(1);
        usuario.setNombre("David");
        usuario.setApellido("Hincapie");
        usuario.setEmail("nn");
        usuario.setTelefono("911");
        usuario.setPassword("Messi");

        Usuario usuario2= new Usuario();
        usuario2.setId(2112);
        usuario2.setNombre("Angie");
        usuario2.setApellido("Pachon");
        usuario2.setEmail("nn");
        usuario2.setTelefono("911");
        usuario2.setPassword("RBD");

        Usuario usuario3= new Usuario();
        usuario3.setId(777);
        usuario3.setNombre("Kira");
        usuario3.setApellido("Montero");
        usuario3.setEmail("nn");
        usuario3.setTelefono("111");
        usuario3.setPassword("Messi");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        return usuarios;
    }
//
//    @RequestMapping(value = "usuario")
//    public Usuario modifyUsuario(){
//        Usuario usuario= new Usuario();
//        usuario.setNombre("David");
//        usuario.setApellido("Hincapie");
//        usuario.setEmail("nn");
//        usuario.setTelefono("911");
//        usuario.setPassword("Messi");
//        return usuario;
//    }
//
//    @RequestMapping(value = "usuario")
//    public Usuario deleteUsuario(){
//        Usuario usuario= new Usuario();
//        usuario.setNombre("David");
//        usuario.setApellido("Hincapie");
//        usuario.setEmail("nn");
//        usuario.setTelefono("911");
//        usuario.setPassword("Messi");
//        return usuario;
//    }
//
//    @RequestMapping(value = "usuario")
//    public Usuario buscarUsuario(){
//        Usuario usuario= new Usuario();
//        usuario.setNombre("David");
//        usuario.setApellido("Hincapie");
//        usuario.setEmail("nn");
//        usuario.setTelefono("911");
//        usuario.setPassword("Messi");
//        return usuario;
//    }
}
