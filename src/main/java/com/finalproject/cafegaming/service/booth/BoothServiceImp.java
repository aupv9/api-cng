package com.finalproject.cafegaming.service.booth;

import com.finalproject.cafegaming.dao.BoothRepository;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.Booth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @author AuPhan
 */

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
        booth1.setCloseTime(booth.getCloseTime());
        booth1.setOpenTime(booth.getOpenTime());
        booth1.setDescription(booth.getDescription());
        booth1.setComment(booth.getComment());

        booth1.setStatus(booth.getStatus());
        booth1.setType(booth.getType());
        booth1.setMainMenu(booth.getMainMenu());
        booth1.setBusinessPhone(booth.getBusinessPhone());

        booth1.setCategory(booth.getCategory());
        booth1.setGenre(booth.getGenre());
        booth1.setPhoto(booth.getPhoto());
        booth1.setFoods(booth.getFoods());
        booth1.setPromotion(booth.getPromotion());
        booth1.setService(booth.getService());

        return null;
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


        return null;
    }

    @Override
    public List<Booth> findAllByProvince(String province, Pageable pageable) {
        List<Booth> booths=new ArrayList<>();
        boothRepository.findAll(pageable).getContent().forEach(booth -> {

        });
        return booths;
    }


    @Override
    public List<Booth> findAllByTitleContaining(String title, Pageable pageable) {
        return boothRepository.findAllByTitleContaining(title,pageable).getContent();
    }
}
