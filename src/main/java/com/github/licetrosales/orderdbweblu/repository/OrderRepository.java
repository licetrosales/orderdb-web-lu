package com.github.licetrosales.orderdbweblu.repository;

import com.github.licetrosales.orderdbweblu.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    private List<Order> orders;

    // Constructor
    public OrderRepository(List<Order> orders){
        this.orders = orders;
    }

    // function list()
    public List<Order> list() {
        return orders;
    }

    // function get order

    public Order get(String id){
        for (Order order: orders){
            if (order.getId().equals(id)){
                return order;
            }
        }
        return null;
    }


}
