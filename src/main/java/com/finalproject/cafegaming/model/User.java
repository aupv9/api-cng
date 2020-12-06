package com.finalproject.cafegaming.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(allowSetters = true,value = {"password","code","name"})
public class User extends BaseModel{

    @Indexed(unique = true,name = "username_index",direction = IndexDirection.ASCENDING)
    private String username;

    private String password;
    private List<String> roles;
    private String firstName;
    private String lastName;
    private LocalDateTime birthday;
    private String image;
    private String address;

    @Indexed(unique = true,name = "email_index")
    private String email;

    private Boolean isActive;

    private String phone;

    @JsonIgnore
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
