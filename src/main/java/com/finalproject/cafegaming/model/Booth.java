package com.finalproject.cafegaming.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
/**
 * @author AuPhan
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("booth")
@JsonIgnoreProperties(value = {"code","name"})
public class Booth extends BaseModel{

    private String title;
    private String type;
    private String mainMenu;

    @DBRef
    private Set<Category> category;

    @DBRef
    private Set<Promotion> promotion;

    @DBRef
    private Set<Genre> genre;

    @DBRef
    private Set<Food> foods;

    @DBRef
    private List<Service> service;

    @DBRef
    private Set<Photo> photo;

    @DBRef
    private Province province;

    @DBRef
    private District district;

    @DBRef
    private List<Comment> comment;

    private String businessPhone;
    private String openTime;
    private String closeTime;
    private String description;
    private String address;

    public Double getPointFromComment(){
        AtomicReference<Double> pointRef = new AtomicReference<>(0.d);
        this.comment.forEach(comment1 -> {
            pointRef.updateAndGet(v -> v + comment1.getPoint());
        });
        Double point = (pointRef.get() / this.comment.size());
        return point;
    }
}
