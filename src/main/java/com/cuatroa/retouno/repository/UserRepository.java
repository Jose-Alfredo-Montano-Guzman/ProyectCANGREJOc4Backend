package com.cuatroa.retouno.repository;

import com.cuatroa.retouno.repository.crud.UserCrudRepository;
import com.cuatroa.retouno.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amontano
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     * metodo para alistar todos los usuario
     * @return 
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    /**
     * Busca un elemento con el id enviado
     * @param id
     * @return 
     */
    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }
    /**
     * Insertar o actualizar información
     * @param user
     * @return 
     */
    public User save(User user){
        return userCrudRepository.save(user);
    }
    /**
     * Verifica la existencia del email
     * @param email
     * @return 
     */
    public boolean exiteEmail(String email){
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }
    /**
     * Verifica la autenticación con el email y la contraseña
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> autenticarUsuario(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}
