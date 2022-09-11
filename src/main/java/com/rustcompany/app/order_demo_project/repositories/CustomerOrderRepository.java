package com.rustcompany.app.order_demo_project.repositories;

import com.rustcompany.app.order_demo_project.domain.CustomerOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.Optional;

@Repository
public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Long> {
    @Override
    Optional<CustomerOrder> findById(Long aLong);

    @Override
    List<CustomerOrder> findAll();

    @Override
    void deleteById(Long aLong);

    @Override
    <S extends CustomerOrder> S save(S entity);
}
