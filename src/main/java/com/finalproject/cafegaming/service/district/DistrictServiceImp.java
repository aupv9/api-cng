package com.finalproject.cafegaming.service.district;

import com.finalproject.cafegaming.dao.DistrictRepository;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.District;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DistrictServiceImp implements DistrictService{
    @Override
    public List<District> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<District> findAllByLocation(String id, Pageable pageable) {
        return null;
    }

    @Override
    public Boolean save(District district) {
        return null;
    }

    @Override
    public Boolean update(District district) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public District findById(String s) {
        return null;
    }


//    final DistrictRepository districtRepository;
//
//    public DistrictServiceImp(DistrictRepository districtRepository) {
//        this.districtRepository = districtRepository;
//    }
//
//    @Override
//    public List<District> findAll(Pageable pageable) {
//        return districtRepository.findAll(pageable).getContent();
//    }
//
//    @Override
//    public List<District> findAllByLocation(String id, Pageable pageable) {
//        return districtRepository.findAllByLocation(id, pageable).getContent();
//    }
//
//    @Override
//    public Boolean save(District district) {
//        return districtRepository.save(district) instanceof District;
//    }
//
//    @Override
//    public Boolean update(District district) {
//        District district1 =findById(district.getId());
//        district1.setCode(district.getCode());
//        district1.setName(district.getName());
//        district1.setIdLocation(district.getIdLocation());
//        district1.setStatus(district.getStatus());
//        district1.setUpdateAt(district.getUpdateAt());
//        return save(district1);
//    }
//
//    @Override
//    public Boolean delete(String id) {
//        District district = findById(id);
//        district.setStatus("Not Active");
//        district.setUpdateAt(LocalDateTime.now());
//        return save(district);
//    }
//
//    @Override
//    public District findById(String s) {
//        return districtRepository.findById(s).orElseThrow(ResourceException::new);
//    }

}
