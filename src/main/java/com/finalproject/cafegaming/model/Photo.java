package com.finalproject.cafegaming.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document("photo")
public class Photo {

    @Id
    private String id;
    private String url;
    private String createdAt;
    private String status;
}
