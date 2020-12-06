package com.finalproject.cafegaming.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Document("comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"code","name"})
public class Comment extends BaseModel {

    private String title;
    private String content;
    private Double point = 5.D;

    @DBRef
    private Booth booth;
}
