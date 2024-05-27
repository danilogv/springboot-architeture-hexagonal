package com.danilo.springbootarchiteturehexagonal.application.design_patterns.facade;

import com.danilo.springbootarchiteturehexagonal.adapter.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FacadeRepository {

    @Autowired
    protected ProductRepository product;

}
