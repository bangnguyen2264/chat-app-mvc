package com.example.web_socket.reopository;

import com.example.web_socket.model.entity.User;
import com.example.web_socket.model.enums.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByStatus(Status status);
}
