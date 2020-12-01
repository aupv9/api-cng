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
    private String open_time;
    private String close_time;
    private String description;
    private String address;
    private String createAt;
    private String updateAt;
    private List<String> zone;
    private List<String> district;
    private List<String> owner;
    private String status;
    private List<String> review;
    private Integer rating;
}
