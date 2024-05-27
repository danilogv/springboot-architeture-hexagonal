package com.danilo.springbootarchiteturehexagonal.application.design_patterns.singleton;

import com.danilo.springbootarchiteturehexagonal.application.dto.ErrorDTO;
import com.danilo.springbootarchiteturehexagonal.application.dto.ProductDTO;
import com.danilo.springbootarchiteturehexagonal.application.usecase.ChangeProductUseCase;
import com.danilo.springbootarchiteturehexagonal.application.usecase.InsertProductUseCase;
import com.danilo.springbootarchiteturehexagonal.application.usecase.RemoveProductUseCase;
import com.danilo.springbootarchiteturehexagonal.application.usecase.SearchAllProductsUseCase;
import com.danilo.springbootarchiteturehexagonal.application.usecase.SearchOneProductUseCase;
import com.danilo.springbootarchiteturehexagonal.domain.model.Product;
import lombok.Getter;

public class Singleton {

    @Getter
    private static Product product = new Product();

    @Getter
    private static ProductDTO productDTO = new ProductDTO();

    @Getter
    private static final ErrorDTO error = new ErrorDTO();

    @Getter
    private static final InsertProductUseCase insertProductUseCase = new InsertProductUseCase();

    @Getter
    private static final ChangeProductUseCase changeProductUseCase = new ChangeProductUseCase();

    @Getter
    private static final RemoveProductUseCase removeProductUseCase = new RemoveProductUseCase();

    @Getter
    private static final SearchOneProductUseCase searchOneProductUseCase = new SearchOneProductUseCase();

    @Getter
    private static final SearchAllProductsUseCase searchAllProductsUseCase = new SearchAllProductsUseCase();

    public static void resetProduct() {
        product = new Product();
    }

    public static void resetProductDTO() {
        productDTO = new ProductDTO();
    }

}
