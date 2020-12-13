package com.finalproject.cafegaming.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author AuPhan
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Document("photo")
@AllArgsConstructor
@NoArgsConstructor
public class Photo extends BaseModel{

    private String url;
    private String download;
    private String title;
    @DBRef
    private Booth booth;
}
