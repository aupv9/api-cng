package com.finalproject.cafegaming.controller;


import com.finalproject.cafegaming.model.Address;
import com.finalproject.cafegaming.model.District;
import com.finalproject.cafegaming.service.address.AddressService;
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
public class AddressController {


    final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping(value = "/addresss",produces = "application/json")
    public ResponseEntity<List<Address>> getAddresss(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10")int size
    ){
        List<Address> addressList = null;
        Pageable paging = PageRequest.of(page, size);

        addressList = addressService.findAll(paging);

        return  addressList != null ? new ResponseEntity<>(addressList, HttpStatus.OK):
                new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
    }



    @PostMapping(value = "/address",produces = "application/json")
    public ResponseEntity<?> saveDistrict(@RequestBody @Validated Address address){
        return  addressService.save(address) != null ? new ResponseEntity<>(true, HttpStatus.CREATED):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/address")
    public ResponseEntity<?> update(@RequestBody @Validated Address address){
        return  addressService.update(address) != null ? new ResponseEntity<>(true, HttpStatus.CREATED):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/address")
    public ResponseEntity<?> delete(@RequestParam String id){
        return  addressService.delete(id) != null ? new ResponseEntity<>(true, HttpStatus.CREATED):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

}
