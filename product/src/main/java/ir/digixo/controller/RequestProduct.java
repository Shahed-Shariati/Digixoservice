package ir.digixo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.math.BigDecimal;


@Data
public class RequestProduct {
    private BigDecimal price;

    private String name ;

    private String description ;

    private String codeDiscount;
}
