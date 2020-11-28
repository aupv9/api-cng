package com.finalproject.cafegaming.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("province")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province {

    @Id
    private String id;
    @Indexed
    private String code;
    private String name;
    private String status;
}
