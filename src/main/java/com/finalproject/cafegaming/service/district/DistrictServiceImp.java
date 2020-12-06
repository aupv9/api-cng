package com.finalproject.cafegaming.service.district;

import com.finalproject.cafegaming.dao.DistrictRepository;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.District;
import com.finalproject.cafegaming.model.Province;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
public class DistrictServiceImp implements DistrictService{

    final DistrictRepository districtRepository;

    public DistrictServiceImp(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }


    @Override
    public List<District> findAll(Pageable pageable) {
        return districtRepository.findAll(pageable).getContent();
    }

    @Override
    public List<District> findAllByProvinceCode(String code, Pageable pageable) {
        return districtRepository.findAllByProvinceId(code,pageable).getContent();
    }

    @Override
    public Boolean save(District district) {
        return districtRepository.save(district) instanceof District;
    }

    @Override
    public Boolean update(District district) {
        District district1 = findById(district.getId());
        district1.setCode(district.getCode());
        district1.setName(district.getName());
        district1.setStatus(district.getStatus());
        district1.setProvince(district.getProvince());

        return save(district1);
    }

    @Override
    public Boolean delete(String id) {
        District district = findById(id);
        return  update(district);
    }

    @Override
    public District findById(String s) {
        return districtRepository.findById(s).orElseThrow(ResourceException::new);
    }
}
