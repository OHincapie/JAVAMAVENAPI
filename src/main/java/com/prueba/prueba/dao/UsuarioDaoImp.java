package com.prueba.prueba.dao;

import com.prueba.prueba.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    @Override
    public void eliminar(Long id) {
        Usuario usuario=entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);
    }

    @Override
    public void createUser(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public boolean loginVerify(Usuario usuario) {
        String query ="FROM Usuario WHERE email = :email";
        List<Usuario> resultado=entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if(resultado.isEmpty()){
            return false;
        }
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        String passwordHashed= resultado.get(0).getPassword();
        return argon2.verify(passwordHashed, usuario.getPassword());//Verifica la password ya hasheada con la password ingresada
        // se podria !resultado.isEmpty()
    }
}
