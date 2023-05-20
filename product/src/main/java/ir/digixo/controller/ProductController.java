package ir.digixo.controller;


import ir.digixo.entity.Product;
import ir.digixo.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService service ;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/create")
    public Product saveProduct(@RequestBody RequestProduct p){
       return service.saveProduct(p);
    }
    @GetMapping("/fetch/{id}")
    public Product getProduct(@PathVariable Long id){
       var result =  service.getProduct(id);
       if(result.isPresent()){
           return  result.get();
       }
      return null;
    }
}
