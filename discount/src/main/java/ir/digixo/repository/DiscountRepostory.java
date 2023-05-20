package ir.digixo.repository;

import ir.digixo.entity.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiscountRepostory extends JpaRepository<DiscountEntity, Long> {

    public Optional<DiscountEntity> findByCode(String code);
}
