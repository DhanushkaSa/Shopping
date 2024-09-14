package com.shopping.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Persistent;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")

public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDateTime;

    private double totalPrice;

    @PrePersist
    private void onCreate(){
        this.orderDateTime=LocalDateTime.now();
    }

    @ManyToMany
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name="orderId"),inverseJoinColumns = @JoinColumn(name="productd"))
    private List<Product> orderProducts;

}
