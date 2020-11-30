package com.finalproject.cafegaming.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("review")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    private String id;
    private String content;
    private Integer rate;
    private LocalDateTime createdAt;
    private String createdBy;
    private String status;
}
