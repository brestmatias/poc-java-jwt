package com.example.ssadminbackend.authorization;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findFirstByNameAndPassword (String name, String password);

}
