package ir.digixo.discount;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class DiscountEntity {
    private Long id;
    private  String code ;
    private BigDecimal discount;
    private LocalDate expireDate ;
}
