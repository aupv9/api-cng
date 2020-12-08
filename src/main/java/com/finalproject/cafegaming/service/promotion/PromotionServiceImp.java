package com.finalproject.cafegaming.service.promotion;

import com.finalproject.cafegaming.dao.PromotionRepository;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.Promotion;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

    /**
     * @version 1
     * @author AuPhan
     */
@Service
public class PromotionServiceImp implements PromotionService{

    final PromotionRepository promotionRepository;

        public PromotionServiceImp(PromotionRepository promotionRepository) {
            this.promotionRepository = promotionRepository;
        }

        @Override
    public List<Promotion> findAll(Pageable pageable) {
        return promotionRepository.findAll(pageable).toList();
    }

    @Override
    public Boolean save(Promotion promotion) {
        return promotionRepository.save(promotion) instanceof Promotion;
    }

    @Override
    public Boolean update(Promotion promotion) {
        Promotion promotion1 = new Promotion();
        promotion1.setCode(promotion.getCode());
        promotion1.setName(promotion.getName());
        promotion1.setStartDate(promotion.getStartDate());
        promotion1.setEndDate(promotion.getEndDate());
        promotion1.setImagePath(promotion.getImagePath());
        promotion1.setDescription(promotion.getDescription());
        promotion1.setQuantity(promotion.getQuantity());
        promotion1.setValue(promotion.getValue());
        promotion1.setNote(promotion.getNote());
        promotion1.setStatus(promotion.getStatus());
        return save(promotion1);
    }

    @Override
    public Boolean delete(String id) {
        Promotion promotion = new Promotion();
        promotion.setStatus("End");

        return save(promotion);
    }

    @Override
    public Promotion findById(String s) {
        return promotionRepository.findById(s).orElseThrow(ResourceException::new);
    }
}
