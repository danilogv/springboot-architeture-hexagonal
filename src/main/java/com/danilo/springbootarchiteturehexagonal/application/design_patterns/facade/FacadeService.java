package com.danilo.springbootarchiteturehexagonal.application.design_patterns.facade;

import com.danilo.springbootarchiteturehexagonal.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class FacadeService {

    @Autowired
    protected ProductService product;

}
