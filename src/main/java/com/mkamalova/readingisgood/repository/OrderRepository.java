package com.mkamalova.readingisgood.repository;

import com.mkamalova.readingisgood.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String>
{
}
