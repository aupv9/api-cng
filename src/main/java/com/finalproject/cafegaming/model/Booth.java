package com.finalproject.cafegaming.model;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document("booth")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booth {

    @Id
    private String id;
    private String title;
    private String type;

    @Field(name = "mainmenu")
    private String mainMenu;

    private String createdBy;
    private List<String> category;
    private List<String> promotion;
    private List<String> genre;
    private List<String> foods;
    private List<String> service;
    private List<String> photo;
    private List<String> review;

    private String businessphone;

    @Field(name = "opentime")
    private String openTime;

    @Field(name = "closetime")
    private String closeTime;

    private String description;
    private String address;
    @Nullable
    private LocalDateTime createAt;
    @Nullable
    private LocalDateTime updateAt;
    private List<String> owner;
    private String status;
    private Float rating;
}
