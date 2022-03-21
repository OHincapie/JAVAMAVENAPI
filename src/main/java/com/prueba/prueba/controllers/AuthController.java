package com.prueba.prueba.controllers;

import com.prueba.prueba.dao.UsuarioDao;
import com.prueba.prueba.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class AuthController {
    @Autowired
    private UsuarioDao usuarioDao;


    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody Usuario usuario){
        if(usuarioDao.loginVerify(usuario)){
            return "OK";
        } else{
            return "FAIL";
        }
    }
}
