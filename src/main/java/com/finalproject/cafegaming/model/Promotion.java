package com.finalproject.cafegaming.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
/**
 * @author AuPhan
 */

@EqualsAndHashCode(callSuper = true)
@Document(collection = "promotion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promotion extends BaseModel{

    private String description = "";
    private int value = 0;
    private LocalDateTime startDate=LocalDateTime.now();
    private LocalDateTime endDate = LocalDateTime.now();
    private String imagePath = "";
    private String note = "";
    private Integer quantity = 0;
    @DBRef
    private Booth  booth;
}
