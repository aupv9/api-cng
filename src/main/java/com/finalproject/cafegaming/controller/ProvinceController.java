package com.finalproject.cafegaming.controller;


import com.finalproject.cafegaming.model.Province;
import com.finalproject.cafegaming.service.province.ProvinceService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProvinceController {

    final ProvinceService provinceService;

    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }


    @GetMapping(value = "/provinces",produces = "application/json")
    public ResponseEntity<List<Province>> getBoothsByDistrict(@RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10")int size
                                                         ){
        List<Province> provinces = null;
        Pageable paging = PageRequest.of(page, size);

        provinces = provinceService.findAll(paging);

        return  provinces != null ? new ResponseEntity<>(provinces, HttpStatus.OK):
                new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
    }
}
