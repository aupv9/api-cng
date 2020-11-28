package com.finalproject.cafegaming.service.booth;

import com.finalproject.cafegaming.dao.BoothRepository;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.Booth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoothServiceImp implements BoothService{

    @Autowired
    BoothRepository boothRepository;

    @Override
    public List<Booth> findAll() {
        return boothRepository.findAll();
    }

    @Override
    public Booth findById(String id) {
        return boothRepository.findById(id).orElseThrow(ResourceException::new);
    }

    @Override
    public Boolean insert(Booth booth) {
        return boothRepository.save(booth) instanceof  Booth;
    }

    @Override
    public Boolean update(Booth booth) {
        Booth booth1 = findById(booth.getId());
        booth1.setTitle(booth.getTitle());
        booth1.setAddress(booth.getAddress());
        booth1.setClose_time(booth.getClose_time());
        booth1.setOpen_time(booth.getOpen_time());
        booth1.setDescription(booth.getDescription());
        booth1.setDistrict(booth.getDistrict());
        booth1.setOwner(booth.getOwner());
        booth1.setRating(booth.getRating());
        booth1.setReview(booth.getReview());
        booth1.setStatus(booth.getStatus());
        booth1.setZone(booth.getZone());
        return null;
    }

    @Override
    public List<Booth> findByDistrict(String s) {
        return boothRepository.findAllByDistrict(s);
    }

    @Override
    public Boolean delete(String id) {
        Booth booth = findById(id);
        booth.setStatus("CLOSE");
        return boothRepository.save(booth) instanceof  Booth;
    }

    @Override
    public List<Booth> findAll(Pageable pageable) {
        return boothRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Booth> findAllByDistrict(String dis, Pageable pageable) {

        return boothRepository.findAllByDistrict(dis,pageable).getContent();
    }

    @Override
    public List<Booth> findAllByZone(String dis, Pageable pageable) {
        return boothRepository.findAllByZone(dis,pageable);
    }

    @Override
    public List<Booth> findAllByTitleContaining(String title, Pageable pageable) {
        return boothRepository.findAllByTitleContaining(title,pageable).getContent();
    }
}
