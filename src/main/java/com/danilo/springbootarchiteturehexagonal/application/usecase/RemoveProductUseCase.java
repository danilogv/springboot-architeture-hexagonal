package com.danilo.springbootarchiteturehexagonal.application.usecase;

import com.danilo.springbootarchiteturehexagonal.application.design_patterns.facade.FacadeService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RemoveProductUseCase extends FacadeService {

    public void remove(UUID id) {
        this.product.remove(id);
    }

}
