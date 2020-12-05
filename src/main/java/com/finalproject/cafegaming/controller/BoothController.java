package com.finalproject.cafegaming.controller;


import com.finalproject.cafegaming.model.Booth;
import com.finalproject.cafegaming.service.booth.BoothService;
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
public class BoothController {

    final BoothService boothService;

    public BoothController(BoothService boothService) {
        this.boothService = boothService;
    }


    @GetMapping(value = "/booth-province")
    public ResponseEntity<List<Booth>> getBoothsByProvin(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "10")int size,
                                                           @RequestParam(required = false) String province
                                                           ){
        Pageable paging = PageRequest.of(page, size);
        List<Booth> booths = boothService.findAllByProvince(province,paging);

        return  booths != null ? new ResponseEntity<>(booths, HttpStatus.OK):
                new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/booths",produces = "application/json")
    public ResponseEntity<List<Booth>> getBoothsByDistrict(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "10")int size
                                                          ){

        Pageable paging = PageRequest.of(page, size);
        List<Booth> booths = boothService.findAll(paging);

        return  booths != null ? new ResponseEntity<>(booths, HttpStatus.OK):
                new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/booth/{id}",produces = "application/json")
    public ResponseEntity<Booth> getBooth(@PathVariable("id")String id){
        Booth booth =  boothService.findById(id);
        return  booth != null ? new ResponseEntity<>(booth, HttpStatus.OK):
                new ResponseEntity<>(new Booth(),HttpStatus.NOT_FOUND);
    }

//    @GetMapping(value = "/booths/{district}",produces = "application/json")
//    public ResponseEntity<List<Booth>> getBoothByDistrict(@PathVariable("district")String dictrict){
//        List<Booth> booths =  boothService.findByDistrict(dictrict);
//        return  booths != null ? new ResponseEntity<>(booths, HttpStatus.OK):
//                new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
//    }



    @PostMapping(value = "/booth",produces = "application/json")
    public ResponseEntity<?> saveBooth(@RequestBody @Validated Booth booth){
        return boothService.insert(booth) ? new ResponseEntity<>(true,HttpStatus.CREATED):
                new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/booth")
    public ResponseEntity<?>  updateBooth(@RequestBody Booth booth){
        return boothService.update(booth)? new ResponseEntity<>(true,HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/booth/{id}")
    public ResponseEntity<?> deleteBooth(@PathVariable("id") String id){
        return  boothService.delete(id) ?new ResponseEntity<>(true,HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }
}
