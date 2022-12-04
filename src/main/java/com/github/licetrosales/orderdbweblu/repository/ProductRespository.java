package com.github.licetrosales.orderdbweblu.repository;

import com.github.licetrosales.orderdbweblu.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRespository {

    private List<Product> products;

    // Constructor
    public ProductRespository(List<Product> products) {
        this.products = products;
    }

    // function list() lists all products
    public List<Product> list() {
        return products;
    }

    // function get a product with id
    public Product get(String id) {
        for (Product product : products) {
            if (product.id().equals(id)) {
                return product;
            }

        }
        return null;
    }
}
