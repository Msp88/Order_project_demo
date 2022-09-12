package com.rustcompany.app.order_demo_project.dto;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class CustomerOrderDto {
    Long id;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    @NotEmpty(message = "Email cannot be empty")
    String email;

    @NotEmpty(message = "Phone Number cannot be empty")
    String phoneNumber;

    @NotEmpty(message = "Address cannot be empty")
    String address;
}
