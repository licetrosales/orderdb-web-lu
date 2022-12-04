package com.github.licetrosales.orderdbweblu.service;


import com.github.licetrosales.orderdbweblu.model.Order;
import com.github.licetrosales.orderdbweblu.model.Product;
import com.github.licetrosales.orderdbweblu.repository.OrderRepository;
import com.github.licetrosales.orderdbweblu.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {

    private OrderRepository orderRepository;
    private ProductRepository productRespository;

    // Constructor
    public ShopService(OrderRepository orderRepository, ProductRepository productRespository){
        this.orderRepository = orderRepository;
        this.productRespository = productRespository;
    }

    // get product by id
    public Product getProduct(String id){
        Product product = productRespository.get(id);
        return product;
    }

    // list all products

    public List<Product> listProducts(){
        return productRespository.list();
    }

    // get order by id

    public Order getOrder(String id){
        return orderRepository.get(id);
    }


    // list orders

    public  List<Order> listOrders(){
        return orderRepository.list();

    }

    // add order

    public Order addOrder(String orderId, List<String> ids){

        List<Product> products = new ArrayList<>();
        for (String id: ids){
            Product product = productRespository.get(id);
            products.add(product);
        }

        Order newOrder = new Order(orderId, products);
        return orderRepository.add(newOrder);
    }

}
