package com.danilo.springbootarchiteturehexagonal.application.usecase;

import com.danilo.springbootarchiteturehexagonal.application.design_patterns.facade.FacadeService;
import com.danilo.springbootarchiteturehexagonal.application.design_patterns.singleton.Singleton;
import com.danilo.springbootarchiteturehexagonal.application.dto.ProductDTO;
import com.danilo.springbootarchiteturehexagonal.domain.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchAllProductsUseCase extends FacadeService {

    public List<ProductDTO> searchAll() {
        List<Product> products = this.product.searchAll();
        List<ProductDTO> productsDTO = new ArrayList<>();

        products.forEach((product) -> {
            ProductDTO dto = Singleton.getProductDTO();
            BeanUtils.copyProperties(product,dto);
            productsDTO.add(dto);
            Singleton.resetProductDTO();
        });

        return productsDTO;
    }

}
