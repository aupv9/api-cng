package com.finalproject.cafegaming.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.BsonTimestamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String username;
    @JsonIgnore
    private String password;
    private List<String> role;
    private String firstName;
    private String lastName;
    private String birthday;
    private String address;
    private String profile;
    private String email;
    @NonNull
    private LocalDateTime createdAt;
    @NonNull
    private LocalDateTime  modifiedAt;

}
