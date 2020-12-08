package com.finalproject.cafegaming.service.service;

import com.finalproject.cafegaming.model.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author AuPhan
 */

public interface ServiceService {
    List<Service> findAll(Pageable page);
    Boolean save(Service service);
    Boolean update(Service service);
    Boolean delete(String s);
    Service findById(String s);
}
