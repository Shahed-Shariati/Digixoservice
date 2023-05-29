package ir.digixo.service;


import ir.digixo.controller.DiscountModel;
import ir.digixo.controller.RequestProduct;
import ir.digixo.entity.Product;
import ir.digixo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ProductService {

    private final RestTemplate restTemplate;
    private final ProductRepository repo ;

    public ProductService(RestTemplate restTemplate,
                          ProductRepository repo) {
        this.restTemplate = restTemplate;
        this.repo = repo;
    }

    public Optional<Product> getProduct(Long id){
     return    repo.findById(id);
    }
    public Product saveProduct(RequestProduct p){
       // var codeDiscount = restTemplate.getForObject("http://localhost:8090/api/discount/getbycode/{code}" , DiscountModel.class ,p.getCodeDiscount()  );
        var codeDiscount = restTemplate.getForObject("http://DISCOUNT/api/discount/getbycode/{code}" , DiscountModel.class ,p.getCodeDiscount());
        var dis = new BigDecimal(100).subtract(codeDiscount.getDiscount());
        var newPrice = dis.multiply(p.getPrice());
        Product pro = new Product();
        pro.setPrice(newPrice);
        pro.setName(p.getName());
        pro.setDescription(p.getDescription());
        return    repo.save(pro);
    }

}
