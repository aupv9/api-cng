package com.finalproject.cafegaming.service.province;

import com.finalproject.cafegaming.model.Province;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author AuPhan
 */

public interface ProvinceService {
    List<Province> findAll(Pageable page);
    Boolean save(Province province);
    Boolean update(Province province);
    Boolean delete(String province);
    Province findById(String s);
}
