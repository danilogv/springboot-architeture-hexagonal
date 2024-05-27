package com.danilo.springbootarchiteturehexagonal.adapter.persistence;

import com.danilo.springbootarchiteturehexagonal.domain.enumeration.Unit;
import com.danilo.springbootarchiteturehexagonal.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product,UUID> {

    boolean existsByNameAndUnit(String name,Unit unit);

}
