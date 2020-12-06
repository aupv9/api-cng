 package com.finalproject.cafegaming.service.province;

import com.finalproject.cafegaming.dao.ProvinceRepository;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.Province;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImp implements ProvinceService{

    final ProvinceRepository provinceRepository;

    public ProvinceServiceImp(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }


    @Override
    public List<Province> findAll(Pageable page) {
        return provinceRepository.findAll(page).getContent();
    }

    @Override
    public Boolean save(Province province) {
        return provinceRepository.save(province) instanceof Province;
    }

    @Override
    public Boolean update(Province province) {
        Province province1=findById(province.getId());
            province1.setCode(province.getCode());
            province1.setName(province.getName());
            province1.setStatus(province.getStatus());
            province1.setDistricts(province.getDistricts());
        return save(province1);
    }

    @Override
    public Boolean delete(String province) {
        Province province1=findById(province);
        province1.setStatus("Not");
        return update(province1);
    }

    @Override
    public Province findById(String s) {
        return provinceRepository.findById(s).orElseThrow(ResourceException::new);
    }
}
