package com.finalproject.cafegaming.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("district")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {

    @Id
    private String id;
    private String code;
    private String name;
    private String province;
    private String idLocation;
    private String status;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
