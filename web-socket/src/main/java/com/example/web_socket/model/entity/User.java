package com.example.web_socket.model.entity;

import com.example.web_socket.model.enums.Status;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data

public class User {
    @Id
    private String nickName;
    private String fullName;
    private Status status;
}
