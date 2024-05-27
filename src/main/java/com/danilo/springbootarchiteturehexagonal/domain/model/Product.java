package com.danilo.springbootarchiteturehexagonal.domain.model;

import com.danilo.springbootarchiteturehexagonal.domain.enumeration.Unit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"name","unit"})
public class Product implements Serializable {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id",nullable = false,unique = true)
    private UUID id;

    @Column(name = "name",nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit",nullable = false)
    private Unit unit;

    @Column(name = "unitary_value",nullable = false)
    private BigDecimal unitaryValue;

    @Column(name = "due_date",nullable = false)
    private LocalDate dueDate;

}
