package com.rustcompany.app.order_demo_project.domain;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer_order")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "email")
    String email;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "address")
    String address;
}
