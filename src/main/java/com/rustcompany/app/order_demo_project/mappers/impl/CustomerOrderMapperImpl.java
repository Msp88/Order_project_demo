package com.rustcompany.app.order_demo_project.mappers.impl;

import com.rustcompany.app.order_demo_project.domain.CustomerOrder;
import com.rustcompany.app.order_demo_project.dto.CustomerOrderDto;
import com.rustcompany.app.order_demo_project.mappers.CustomerOrderMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerOrderMapperImpl implements CustomerOrderMapper {

    @Override
    public CustomerOrder dtoToCustomerOrder(CustomerOrderDto customerOrderDto) {

        if (customerOrderDto == null) {
            return null;
        }

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setId(customerOrderDto.getId());
        customerOrder.setAddress(customerOrderDto.getAddress());
        customerOrder.setEmail(customerOrderDto.getEmail());
        customerOrder.setPhoneNumber(customerOrderDto.getPhoneNumber());

        return customerOrder;
    }

    @Override
    public CustomerOrderDto customerOrderToDto(CustomerOrder customerOrder) {
        if (customerOrder == null) {
            return null;
        }

        CustomerOrderDto customerOrderDto = new CustomerOrderDto();
        customerOrderDto.setId(customerOrder.getId());
        customerOrderDto.setAddress(customerOrder.getAddress());
        customerOrderDto.setEmail(customerOrder.getEmail());
        customerOrderDto.setPhoneNumber(customerOrder.getPhoneNumber());

        return customerOrderDto;
    }
}
