package com.finalproject.cafegaming.service.service;

import com.finalproject.cafegaming.dao.ServiceRepository;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author AuPhan
 */


@org.springframework.stereotype.Service
public class ServiceServiceImp implements ServiceService{

    final ServiceRepository serviceRepository;

    public ServiceServiceImp(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }


    @Override
    public List<Service> findAll(Pageable page) {
        return serviceRepository.findAll(page).toList();
    }

    @Override
    public Boolean save(Service service) {
        return serviceRepository.save(service) instanceof Service;
    }

    @Override
    public Boolean update(Service service) {
        Service service1 = findById(service.getId());
        service1.setCode(service.getCode());
        service1.setName(service.getName());
        service1.setStatus(service.getStatus());

        return save(service1);
    }

    @Override
    public Boolean delete(String s) {
        Service service1 = findById(s);

        service1.setStatus(service1.getStatus());

        return save(service1);
    }

    @Override
    public Service findById(String s) {
        return serviceRepository.findById(s).orElseThrow(ResourceException::new);
    }
}
