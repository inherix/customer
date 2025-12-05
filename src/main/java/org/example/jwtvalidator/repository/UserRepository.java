package org.example.jwtvalidator.repository;

import org.example.jwtvalidator.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {


}
