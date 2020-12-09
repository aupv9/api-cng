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
@Document(collection = "district")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class District extends BaseModel{

    @DBRef
    private Province province;
}
