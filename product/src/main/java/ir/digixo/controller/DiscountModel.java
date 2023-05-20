package ir.digixo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class DiscountModel {
    private Long id;
    private  String code ;
    private BigDecimal discount;
    private LocalDate expireDate ;
}
