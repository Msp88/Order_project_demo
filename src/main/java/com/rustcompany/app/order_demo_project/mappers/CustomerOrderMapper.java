package com.rustcompany.app.order_demo_project.mappers;

import com.rustcompany.app.order_demo_project.domain.CustomerOrder;
import com.rustcompany.app.order_demo_project.dto.CustomerOrderDto;

public interface CustomerOrderMapper {

    CustomerOrder dtoToCustomerOrder(CustomerOrderDto customerOrderDto);

    CustomerOrderDto customerOrderToDto(CustomerOrder customerOrder);
}
