package com.danilo.springbootarchiteturehexagonal.adapter.controller;

import com.danilo.springbootarchiteturehexagonal.application.design_patterns.facade.FacadeProductUseCase;
import com.danilo.springbootarchiteturehexagonal.application.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/product")
public class ProductController extends FacadeProductUseCase {

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ProductDTO product) {
        this.insertProductUseCase.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> change(@RequestBody ProductDTO product) {
        this.changeProductUseCase.change(product);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable UUID id) {
        this.removeProductUseCase.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> searchOne(@PathVariable UUID id) {
        ProductDTO product = this.searchOneProductUseCase.searchOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> searchAll() {
        List<ProductDTO> products = this.searchAllProductsUseCase.searchAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

}
