package com.desaextremo.retouno.repository.crud;

import com.desaextremo.retouno.model.User;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author desarrolloextremo
 */
public interface UserCrudRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    //Optional<User> findByName(String name);
}
