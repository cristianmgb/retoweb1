package com.desaextremo.retouno.service;

import com.desaextremo.retouno.model.User;
import com.desaextremo.retouno.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author desarrolloextremo
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public User registrar(User user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email.trim(), password.trim());
        System.out.println(email);
        System.out.println(password);
        if (usuario.isEmpty()) {
            System.out.println("entra a usuario isempty");
            return new User(email, password, "NO DEFINIDO");
        } else {
            System.out.println("entra a else auntricar usuario");
            return usuario.get();
        }
    }
}
