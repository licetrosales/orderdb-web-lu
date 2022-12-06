package com.github.licetrosales.orderdbweblu.service;

import com.github.licetrosales.orderdbweblu.model.Order;
import com.github.licetrosales.orderdbweblu.repository.OrderRepository;
import com.github.licetrosales.orderdbweblu.repository.ProductRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShopServiceTest {

    // Was brauchen wir noch?
    OrderRepository orderRepository = mock(OrderRepository.class);
    ProductRepository productRepository = mock(ProductRepository.class);
    // Was wir wollen testen

    ShopService shopService = new ShopService(orderRepository, productRepository);

    // Methodenname - Was SOLL passieren, wenn EIN Fall eintritt
    @Test
    void getOrder_shouldReturnOrder_whenOrderIsValid() {

        //GIVEN
        String orderId1 = "1";
        Order expectedOrder = new Order();
        expectedOrder.setId(orderId1);

        //WHEN
        when(orderRepository.get(orderId1)).thenReturn(expectedOrder);
        Order result = shopService.getOrder(orderId1);

        //THEN
        //Ergebnisse vergleichen - result mit Order mit der Id 1
        assertEquals(expectedOrder, result);

        // Wurde eine bestimmte Methode aufgerufen?
        verify(orderRepository).get(orderId1);

    }

    @Test
    void getProduct_shouldReturnProduct_whenProductIsValid() {

        //GIVEN
        String productId1 = "1";
        String productName = "Pullover";
        Product expectedProduct = new Product(productName, productId1);

        //WHEN
        when(productRepository.get(productId1)).thenReturn(expectedProduct);
        Product result = shopService.getProduct(productId1);

        //THEN
        //Ergebnisse vergleichen - result mit Order mit der Id 1
        assertEquals(expectedProduct, result);

        // Wurde eine bestimmte Methode aufgerufen?
        verify(productRepository).get(productId1);

    }

    @Test
    void listProducts_shouldReturnEmptyListOfProducts_whenListIsEmpty() {

        //GIVEN
        List<Product> expected = Collections.emptyList();

        //WHEN
        when(productRepository.list()).thenReturn(Collections.emptyList());
        List<Product> result = shopService.listProducts();

        //THEN
        assertEquals(expected, result);
        verify(productRepository).list();
    }

    @Test
    void listProducts_shouldReturnEListOfProducts_whenListIsNotEmpty() {

        //GIVEN

        Product product1 = new Product("book", "1");
        Product product2 = new Product("ball", "2");
        List<Product> expected = new ArrayList<>();
        expected = List.of(product1, product2);
        //WHEN
        when(productRepository.list()).thenReturn(expected);
        List<Product> result = shopService.listProducts();

        //THEN
        assertEquals(expected, result);
        verify(productRepository).list();
    }


    @Test
    void addOrder_shouldAddOrder_whenOrderIsValid() {

        //GIVEN
        String orderId1 = "1";

        List<String> ids = Collections.emptyList();
        Order orderExpected = new Order(orderId1, Collections.emptyList());

        // WHEN
        when(shopService.addOrder(orderId1, ids)).thenReturn(orderExpected);
        Order result = shopService.addOrder(orderId1, ids);

        //THEN
        assertEquals(orderExpected, result);
        verify(productRepository).list();
    }

    @Test
    void addOrder_shouldReturnOrder_whenOrderIsAdded() {
        //GIVEN
        Product product1 = new Product("book", "1");
        Product product2 = new Product("ball", "2");
        String orderId1 = "1";
        List<Product> products = List.of(product1, product2);
        Order expected= new Order(orderId1, products);

        List<String> ids = List.of("1", "2");
        //WHEN
        when(orderRepository.add(expected)).thenReturn(expected);
        when(productRepository.get(ids.get(0))).thenReturn(product1);
        when(productRepository.get(ids.get(1))).thenReturn(product2);

        Order result = shopService.addOrder(orderId1, ids);
        //THEN

        assertEquals(expected, result);


    }


}