package com.finalproject.cafegaming.model;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("district")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {

    @Id
    private String id;
    @Indexed
    private String code;
    private String name;
    private String province;
    private String idLocation;
    private String status;
    @Nullable
    private LocalDateTime createAt;
    @Nullable
    private LocalDateTime updateAt;
}
