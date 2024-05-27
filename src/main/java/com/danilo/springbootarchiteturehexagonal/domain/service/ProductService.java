package com.danilo.springbootarchiteturehexagonal.domain.service;

import com.danilo.springbootarchiteturehexagonal.application.design_patterns.facade.FacadeRepository;
import com.danilo.springbootarchiteturehexagonal.domain.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService extends FacadeRepository {

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public void insert(Product product) {
        if (this.product.existsByNameAndUnit(product.getName(),product.getUnit())) {
            String msg = "There aren't already a product with that name and unit.";
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,msg);
        }

        this.product.save(product);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public void change(Product product) {
        if (!this.product.existsByNameAndUnit(product.getName(),product.getUnit())) {
            String msg = "There aren't already a product with that name and unit.";
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,msg);
        }

        this.product.save(product);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public void remove(UUID id) {
        if (!this.product.existsById(id)) {
            String msg = "There aren't already a product with that id.";
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,msg);
        }

        this.product.deleteById(id);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,readOnly = true)
    public Product searchOne(UUID id) {
        Optional<Product> product = Optional.ofNullable(
            this.product.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Product not found.")
            )
        );

        return product.get();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,readOnly = true)
    public List<Product> searchAll() {
        return this.product.findAll();
    }

}
