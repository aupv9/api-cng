package com.finalproject.cafegaming.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Document("genre")
public class Genre extends BaseModel{


}
