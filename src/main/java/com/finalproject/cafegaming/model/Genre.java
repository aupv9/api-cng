package com.finalproject.cafegaming.model;


import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("genre")
public class Genre {

    @Id
    private String id;
    private String code;
    private String name;
    private String status;
    @Nullable
    private LocalDateTime createdAt;
    @Nullable
    private LocalDateTime updatedAt;
}
