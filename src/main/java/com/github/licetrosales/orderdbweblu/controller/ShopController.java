package com.github.licetrosales.orderdbweblu.controller;

import com.github.licetrosales.orderdbweblu.model.Order;
import com.github.licetrosales.orderdbweblu.model.Product;
import com.github.licetrosales.orderdbweblu.service.ShopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("shop")
public class ShopController {
    private ShopService shopService;

    // Constructor
    // Wir wollen keinen leeren Konstruktor (Dependency injection)
    // Dependency Injection = Wofür genau?
    /* Gibt Veantwortung an Spring ab
     + weniger Code schreiben

     Wir verwenden keine leeren Konstrukktoren
     -> Spring verknüft unsere Abhängigkeiten automatisch
     -> Testen wird einfacher
        */

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    // show list of all products
    // Das ist ein Endpunkt
    @GetMapping("products")
    public List<Product> getAllProducts() {
        return shopService.listProducts();
    }
    // show list of all orders
    // Das ist ein Endpunkt
    @GetMapping("orders")
    public List<Order> getAllOrders() {
        return shopService.listOrders();
    }





}
