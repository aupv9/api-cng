package com.finalproject.cafegaming.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(allowSetters = true,value = {"password"})
public class User {
    @Id
    private String id;
    @Indexed
    private String username;
    private String password;
    @Nullable
    private List<String> roles;
    private String firstName;
    private String lastName;
    private LocalDateTime birthday;
    private String address;
    private String profile;
    @Indexed
    private String email;
    @Field(name = "createdAt")
    @Nullable
    private LocalDateTime createdAt;
    @Field(name = "updateAt")
    @Nullable
    private LocalDateTime  updateAt;
    private Boolean isActive;

    @JsonIgnore
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
