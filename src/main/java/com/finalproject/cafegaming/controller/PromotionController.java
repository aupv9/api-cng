package com.finalproject.cafegaming.controller;


import com.finalproject.cafegaming.model.Category;
import com.finalproject.cafegaming.model.Promotion;
import com.finalproject.cafegaming.service.promotion.PromotionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AuPhan
 */

@RestController
@RequestMapping("/api/v1/")
public class PromotionController {


    final PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }


    @GetMapping(value = "/promotions",produces = "application/json")
    public ResponseEntity<List<Promotion>> findAll(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10")int size
    ){
        Pageable paging = PageRequest.of(page, size);

        List<Promotion> promotions = promotionService.findAll(paging);

        return  promotions != null && !promotions.isEmpty()? new ResponseEntity<>(promotions, HttpStatus.OK):
                new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/promotion",produces = "application/json")
    public ResponseEntity<?> save(@RequestBody @Validated Promotion promotion){
        return  promotionService.save(promotion) != null ? new ResponseEntity<>(true, HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/promotion")
    public ResponseEntity<?> update(@RequestBody @Validated Promotion category){
        return  promotionService.update(category) != null ? new ResponseEntity<>(true, HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/promotion")
    public ResponseEntity<?> delete(@RequestParam String id){
        return  promotionService.delete(id) != null ? new ResponseEntity<>(true, HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
