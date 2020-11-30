package com.finalproject.cafegaming.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("booth")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booth {

    @Id
    private String id;
    private String title;
    private Photo picUrl;
    private String openTime;
    private String closeTime;
    private String description;
    private String address;
    private String status;
    private List<Review> reviews;
    private List<Photo> photos;
    private Integer[] priceRange;
    private String shortUrl;
    private String phone;
    private String createdBy;
    private String createdAt;
    private String updatedAt;
}
