package com.softinov.containerizespringboot.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Order {
    private Long id;
    private String name;
    private String description;
    private double price;
}
