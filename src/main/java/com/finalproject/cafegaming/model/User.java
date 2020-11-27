package com.finalproject.cafegaming.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private List<String> roles;
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
    private Boolean isActive;

<<<<<<< Updated upstream
=======
    @JsonIgnore
>>>>>>> Stashed changes
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
