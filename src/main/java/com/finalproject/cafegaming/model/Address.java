package com.finalproject.cafegaming.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private String id;
    private String province;
    private String disctrict;
    private String street;
    private String ward;
    private String number;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private String status;

}
