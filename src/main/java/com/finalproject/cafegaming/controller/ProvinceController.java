package com.finalproject.cafegaming.controller;

import com.finalproject.cafegaming.model.Province;
import com.finalproject.cafegaming.service.province.ProvinceService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping(value = "/province",produces = "application/json")
    public ResponseEntity<Province> getBoothsByDistrict(@RequestParam String id){
        Province province = provinceService.findById(id);
        return  province != null ? new ResponseEntity<>(province, HttpStatus.OK):
                new ResponseEntity<>(new Province(),HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/province",produces = "application/json")
    public ResponseEntity<?> save(@RequestBody @Validated Province province){
        return provinceService.save(province) ? new ResponseEntity<>(true,HttpStatus.CREATED):
                new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/province")
    public ResponseEntity<?>  update(@RequestBody Province province){
        return provinceService.update(province)? new ResponseEntity<>(true,HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/province/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        return  provinceService.delete(id) ?new ResponseEntity<>(true,HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }

}
