package com.finalproject.cafegaming.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Document("province")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province extends BaseModel{

    @DBRef
    private Set<District> districts;
}
