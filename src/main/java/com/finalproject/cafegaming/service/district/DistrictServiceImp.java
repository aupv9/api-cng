package com.finalproject.cafegaming.service.district;

import com.finalproject.cafegaming.dao.DistrictRepository;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.District;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<District> findAllByLocation(String id) {
        return districtRepository.findAllByIdLocation(id).getContent();
    }

    @Override
    public Boolean save(District district) {
        districtRepository.save(district);
        return true;
    }

    @Override
    public Boolean update(District district) {

        District district1 = findById(district.getId());
        district1.setCode(district.getCode());
        district1.setIdLocation(district.getIdLocation());
        district1.setName(district.getName());
        district1.setStatus(district.getStatus());
        district1.setUpdateAt(district.getUpdateAt());
        return save(district1);
    }

    @Override
    public Boolean delete(String id) {
        District district1 = findById(id);
        district1.setStatus("CLOSE");
        return save(district1);
    }

    @Override
    public District findById(String s) {
        return districtRepository.findById(s).orElseThrow(ResourceException::new);
    }
}
