package com.finalproject.cafegaming.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("review")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    private String id;
    private String content;
    private String createAt;
    private String status;

}
