package ir.digixo.service;

import ir.digixo.Discount;
import ir.digixo.entity.DiscountEntity;
import ir.digixo.repository.DiscountRepostory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiscountService {
    private final DiscountRepostory repostory;

    public DiscountService(DiscountRepostory repostory) {
        this.repostory = repostory;
    }

    public DiscountEntity saveDiscount(DiscountEntity d){
       return repostory.save(d);
    }

    public Optional<DiscountEntity> fetchDiscount (Long id){
      return  repostory.findById(id)  ;
    }
    public Optional<DiscountEntity> findByCode (String code){
        return  repostory.findByCode(code)  ;
    }
}
