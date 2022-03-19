package com.prueba.prueba.dao;

import com.prueba.prueba.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;//Servira para hacer la conexión con la base de datos

    @Override
    public List<Usuario> getUsuarios() {
        String query ="FROM Usuario";
        List<Usuario> resultado=entityManager.createQuery(query).getResultList();
        return resultado;
    }

}
