package com.danilo.springbootarchiteturehexagonal.application.design_patterns.facade;

import com.danilo.springbootarchiteturehexagonal.application.usecase.ChangeProductUseCase;
import com.danilo.springbootarchiteturehexagonal.application.usecase.InsertProductUseCase;
import com.danilo.springbootarchiteturehexagonal.application.usecase.RemoveProductUseCase;
import com.danilo.springbootarchiteturehexagonal.application.usecase.SearchAllProductsUseCase;
import com.danilo.springbootarchiteturehexagonal.application.usecase.SearchOneProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;

public class FacadeProductUseCase {

    @Autowired
    protected InsertProductUseCase insertProductUseCase;

    @Autowired
    protected ChangeProductUseCase changeProductUseCase;

    @Autowired
    protected RemoveProductUseCase removeProductUseCase;

    @Autowired
    protected SearchOneProductUseCase searchOneProductUseCase;

    @Autowired
    protected SearchAllProductsUseCase searchAllProductsUseCase;

}
