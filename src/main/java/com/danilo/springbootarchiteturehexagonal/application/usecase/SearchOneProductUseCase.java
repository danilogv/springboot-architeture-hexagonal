package com.danilo.springbootarchiteturehexagonal.application.usecase;

import com.danilo.springbootarchiteturehexagonal.application.design_patterns.facade.FacadeService;
import com.danilo.springbootarchiteturehexagonal.application.design_patterns.singleton.Singleton;
import com.danilo.springbootarchiteturehexagonal.application.dto.ProductDTO;
import com.danilo.springbootarchiteturehexagonal.domain.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SearchOneProductUseCase extends FacadeService {

    public ProductDTO searchOne(UUID id) {
        ProductDTO dto = Singleton.getProductDTO();
        Product product = this.product.searchOne(id);
        BeanUtils.copyProperties(product,dto);
        return dto;
    }

}
