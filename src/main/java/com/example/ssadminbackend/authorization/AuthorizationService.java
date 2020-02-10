package com.example.ssadminbackend.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    @Autowired
    UserRepository userRepository;

    public User create (final User user){
        return userRepository.insert(user);
    }

    public User update (final User user){
        return userRepository.save(user);
    }

    public User getByNameAndPassword(final String name, final String password){
        return userRepository.findFirstByNameAndPassword(name, password);
    }
}
