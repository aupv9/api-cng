package com.finalproject.cafegaming.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private String id;
    private String street;
    private String number;

}
