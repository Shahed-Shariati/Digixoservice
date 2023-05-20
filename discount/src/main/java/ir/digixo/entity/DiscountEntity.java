package ir.digixo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="discount")
@Getter
@Setter
@NoArgsConstructor
public class DiscountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String code ;
    private BigDecimal discount;
    @Column(name = "expire_date")
    @JsonProperty("date")
    private LocalDate expireDate ;
}
