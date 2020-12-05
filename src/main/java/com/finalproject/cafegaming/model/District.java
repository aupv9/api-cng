package com.finalproject.cafegaming.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "district")
@Data
@AllArgsConstructor
public class District extends BaseModel{

    @DBRef
    private Province province;
}
