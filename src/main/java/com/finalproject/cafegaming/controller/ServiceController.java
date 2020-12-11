package com.finalproject.cafegaming.controller;


import com.finalproject.cafegaming.model.Category;
import com.finalproject.cafegaming.model.Promotion;
import com.finalproject.cafegaming.model.Service;
import com.finalproject.cafegaming.service.service.ServiceService;
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
@RequestMapping("api/v1/")
public class ServiceController {

    final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }


    @GetMapping(value = "/services",produces = "application/json")
    public ResponseEntity<List<Service>> findAll(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10")int size
    ){
        Pageable paging = PageRequest.of(page, size);

        List<Service> services = serviceService.findAll(paging);

        return  services != null && !services.isEmpty()? new ResponseEntity<>(services, HttpStatus.OK):
                new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/service",produces = "application/json")
    public ResponseEntity<Service> findById(@RequestParam String id
    ){

        Service service = serviceService.findById(id);

        return  service != null? new ResponseEntity<>(service, HttpStatus.OK):
                new ResponseEntity<>(new Service(),HttpStatus.NOT_FOUND);
    }



    @PostMapping(value = "/service",produces = "application/json")
    public ResponseEntity<?> save(@RequestBody @Validated Service service){
        return  serviceService.save(service) != null ? new ResponseEntity<>(true, HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/service")
    public ResponseEntity<?> update(@RequestBody @Validated Service service){
        return  serviceService.update(service) != null ? new ResponseEntity<>(true, HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/service")
    public ResponseEntity<?> delete(@RequestParam String id){
        return  serviceService.delete(id) != null ? new ResponseEntity<>(true, HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
