package com.example.ProjectMS.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product){
        return productRepo.save(product);
    }
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
    public Product findProductById(Long id){
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFondException("Product with id" + id + "not Found"));

    }
    public void delete(Long id){
        productRepo.deleteById(id);
    }

}
