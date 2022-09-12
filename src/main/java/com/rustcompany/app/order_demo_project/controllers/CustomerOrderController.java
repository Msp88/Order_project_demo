package com.rustcompany.app.order_demo_project.controllers;

import com.rustcompany.app.order_demo_project.dto.CustomerOrderDto;
import com.rustcompany.app.order_demo_project.exception_hadnling.NoSuchOrderException;
import com.rustcompany.app.order_demo_project.services.CustomerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class CustomerOrderController {
    private final CustomerOrderService customerOrderService;

    @GetMapping("order/{orderId}")
    @PreAuthorize("hasAuthority('orders:read_edit')")
    public ResponseEntity<CustomerOrderDto> getToyById(@PathVariable("orderId") Long orderId) {
        Optional<CustomerOrderDto> customerOrderDtoOptional = customerOrderService.getById(orderId);
        return customerOrderDtoOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("orders")
    @PreAuthorize("hasAuthority('orders:read_edit')")
    public ResponseEntity<List<CustomerOrderDto>> getAllOrders() {
        return ResponseEntity.ok(customerOrderService.getAllOrders());
    }

    @PostMapping("order")
    @PreAuthorize("hasAuthority('orders:post')")
    public ResponseEntity<CustomerOrderDto> saveNewToy(@RequestBody @Valid CustomerOrderDto customerOrderDto) {
        return new ResponseEntity<>(customerOrderService.saveNewOrder(customerOrderDto), HttpStatus.CREATED);
    }

    @PutMapping("order/{orderId}")
    @PreAuthorize("hasAuthority('orders:read_edit')")
    public ResponseEntity<CustomerOrderDto> updateOrder(@PathVariable("orderId") Long orderId, @RequestBody CustomerOrderDto customerOrderDto) {
        Optional<CustomerOrderDto> customerOrderDtoOptional = customerOrderService.getById(orderId);
        if (customerOrderDtoOptional.isEmpty()) {
            throw new NoSuchOrderException("Could not find customer order with id: " + orderId);
        }

        CustomerOrderDto updatedDto = customerOrderDtoOptional.get();
        updatedDto.setAddress(customerOrderDto.getAddress());
        updatedDto.setEmail(customerOrderDto.getEmail());
        updatedDto.setPhoneNumber(customerOrderDto.getPhoneNumber());

        CustomerOrderDto retrievedOrder = customerOrderService.updateOrder(updatedDto);
        return ResponseEntity.ok(retrievedOrder);
    }

    @DeleteMapping("order/{orderId}")
    @PreAuthorize("hasAuthority('orders:read_edit')")
    public ResponseEntity<Void> deleteOrderById(@PathVariable("orderId") Long orderId) {
        Optional<CustomerOrderDto> customerOrderDtoOptional = customerOrderService.getById(orderId);
        if (customerOrderDtoOptional.isEmpty()) {
            throw new NoSuchOrderException("Could not find customer order with id: " + orderId);
        }

        customerOrderService.deleteOrderById(orderId);
        return ResponseEntity.noContent().build();
    }
}
