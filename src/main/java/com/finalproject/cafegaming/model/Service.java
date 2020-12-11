package com.finalproject.cafegaming.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @author AuPhan
 */

@EqualsAndHashCode(callSuper = true)
@Document(collection = "service")
@AllArgsConstructor
@Data
public class Service extends BaseModel{
}
