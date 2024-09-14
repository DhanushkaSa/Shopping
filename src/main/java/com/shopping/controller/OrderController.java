package com.shopping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.DTO.OrderDto;
import com.shopping.entity.Order;
import com.shopping.entity.Product;
import com.shopping.service.OrderService;
import com.shopping.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>>getAllOrders(){
        return ResponseEntity.status(200).body(orderService.getAllOrders());
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto){
          Order order=new Order();
          order.setTotalPrice(0.0);
          List<Product> products=new ArrayList<>();
          List<Long> productIds=orderDto.getProductIds();

          productIds.forEach(productId->{
                 Product product=productService.getProduct(productId);

                 if(product!=null){
                    products.add(product);
                    order.setTotalPrice(order.getTotalPrice()+product.getPrice());
                 }
          });

          order.setOrderProducts(products);
          
          return ResponseEntity.status(200).body(orderService.createOrder(order));
          
    }
}
