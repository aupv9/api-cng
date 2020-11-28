package com.finalproject.cafegaming.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("owner")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    @Id
    private String id;
    private String phone;
    private List<String> booth;
    private List<String> photo;

}
