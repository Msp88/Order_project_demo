package com.rustcompany.app.order_demo_project.services.impl;

import com.rustcompany.app.order_demo_project.domain.CustomerOrder;
import com.rustcompany.app.order_demo_project.dto.CustomerOrderDto;
import com.rustcompany.app.order_demo_project.mappers.CustomerOrderMapper;
import com.rustcompany.app.order_demo_project.repositories.CustomerOrderRepository;
import com.rustcompany.app.order_demo_project.services.CustomerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;

    private final CustomerOrderMapper customerOrderMapper;

    @Override
    public Optional<CustomerOrderDto> getById(Long orderId) {
        Optional<CustomerOrder> customerOrderOptional = customerOrderRepository.findById(orderId);
        return customerOrderOptional.map(customerOrderMapper::customerOrderToDto);
    }

    @Override
    public List<CustomerOrderDto> getAllOrders() {
        List<CustomerOrder> customerOrders = customerOrderRepository.findAll();

        return customerOrders
                .stream()
                .map(customerOrderMapper::customerOrderToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerOrderDto saveNewOrder(CustomerOrderDto customerOrderDto) {
        CustomerOrder customerOrder = customerOrderRepository.save(customerOrderMapper.dtoToCustomerOrder(customerOrderDto));
        return customerOrderMapper.customerOrderToDto(customerOrder);
    }

    @Override
    public CustomerOrderDto updateOrder(CustomerOrderDto customerOrderDto) {
        return saveNewOrder(customerOrderDto);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        customerOrderRepository.deleteById(orderId);
    }
}
