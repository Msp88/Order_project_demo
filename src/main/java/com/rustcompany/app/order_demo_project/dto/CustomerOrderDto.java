package com.rustcompany.app.order_demo_project.dto;
import lombok.Data;


@Data
public class CustomerOrderDto {
    Long id;
    String email;
    String callNumber;
    String address;
}
