package com.cristiangonzalez.retouno.service;

import com.cristiangonzalez.retouno.repository.UserRepository;
import com.cristiangonzalez.retouno.model.User;

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

    public User save(User user) {
        if (user.getId() == null) {
            if (!validateteEmail(user.getEmail())) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean validateteEmail(String email) {
        return userRepository.validateEmail(email);
    }

    public User authUser(String email, String password) {
        Optional<User> usuario = userRepository.authUser(email.trim(), password.trim());
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
