package com.shopping.DTO;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class ProductDto {
    
    private String name;

    private String description;

    private Double price;

    private Long categoryId;
}
