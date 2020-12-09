package com.finalproject.cafegaming.controller;

import com.finalproject.cafegaming.model.District;
import com.finalproject.cafegaming.service.district.DistrictService;
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
@RequestMapping("/api/v1")
public class DistrictController {


    final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping(value = "/districts",produces = "application/json")
    public ResponseEntity<List<District>> getDistricts(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10")int size
    ){
        List<District> districts = null;
        Pageable paging = PageRequest.of(page, size);

        districts = districtService.findAll(paging);

        return  districts != null ? new ResponseEntity<>(districts, HttpStatus.OK):
                new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/district-province",produces = "application/json")
    public ResponseEntity<List<District>> getDistrictsByLocation(@RequestParam(defaultValue = "0") int page,
                                                                 @RequestParam(defaultValue = "10")int size,
                                                                 @RequestParam String province){
        List<District> districts = null;
        Pageable paging = PageRequest.of(page, size);

        districts = districtService.findAllByProvinceCode(province,paging);

        return  districts != null ? new ResponseEntity<>(districts, HttpStatus.OK):
                new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
    }



    @PostMapping(value = "/district",produces = "application/json")
    public ResponseEntity<?> saveDistrict(@RequestBody @Validated District district){
        return  districtService.save(district) != null ? new ResponseEntity<>(true, HttpStatus.CREATED):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/district")
    public ResponseEntity<?> update(@RequestBody @Validated District district){
        return  districtService.update(district) != null ? new ResponseEntity<>(true, HttpStatus.CREATED):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/district")
    public ResponseEntity<?> delete(@RequestParam String id){
        return  districtService.delete(id) != null ? new ResponseEntity<>(true, HttpStatus.CREATED):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

}