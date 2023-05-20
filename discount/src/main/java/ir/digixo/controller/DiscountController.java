package ir.digixo.controller;


import ir.digixo.entity.DiscountEntity;
import ir.digixo.service.DiscountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/discount")
public class DiscountController {
    private final DiscountService serviceDiscount;

    public DiscountController(DiscountService serviceDiscount) {
        this.serviceDiscount = serviceDiscount;
    }


    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/create")
    public DiscountEntity saveProduct(@RequestBody DiscountEntity p){
        return serviceDiscount.saveDiscount(p);
    }
    @GetMapping("/fetch/{id}")
    public DiscountEntity getProduct(@PathVariable Long id){
        var result =  serviceDiscount.fetchDiscount(id);
        if(result.isPresent()){
            return  result.get();
        }
        return null;
    }
    @GetMapping("/getbycode/{code}")
    public DiscountEntity getDiscountCode(@PathVariable String code){
        var result =  serviceDiscount.findByCode(code);
        if(result.isPresent()){
            return  result.get();
        }
        return null;
    }
}
