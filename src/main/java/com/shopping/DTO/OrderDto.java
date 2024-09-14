package com.shopping.DTO;

import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderDto {
    
    private List<Long> productIds;
}
