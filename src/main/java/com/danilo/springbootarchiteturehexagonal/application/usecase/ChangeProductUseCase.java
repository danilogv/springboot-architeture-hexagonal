package com.danilo.springbootarchiteturehexagonal.application.usecase;

import com.danilo.springbootarchiteturehexagonal.application.design_patterns.facade.FacadeService;
import com.danilo.springbootarchiteturehexagonal.application.design_patterns.singleton.Singleton;
import com.danilo.springbootarchiteturehexagonal.application.dto.ProductDTO;
import com.danilo.springbootarchiteturehexagonal.domain.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ChangeProductUseCase extends FacadeService {

    public void change(ProductDTO dto) {
        ValidateProductUseCase.validateId(dto.getId());
        ValidateProductUseCase.validateName(dto.getName());
        ValidateProductUseCase.validateUnit(dto.getUnit());
        ValidateProductUseCase.validateUnitaryValue(dto.getUnitaryValue());
        ValidateProductUseCase.validateDueDate(dto.getDueDate());
        Product product = Singleton.getProduct();
        BeanUtils.copyProperties(dto,product);
        this.product.change(product);
    }

}
