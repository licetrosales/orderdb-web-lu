package com.github.licetrosales.orderdbweblu.service;

import com.github.licetrosales.orderdbweblu.model.Order;
import com.github.licetrosales.orderdbweblu.model.Product;
import com.github.licetrosales.orderdbweblu.repository.OrderRepository;
import com.github.licetrosales.orderdbweblu.repository.ProductRepository;
import org.junit.jupiter.api.Test;

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

        when(orderRepository.get(orderId1)).thenReturn(expectedOrder);
        //WHEN
        Order result = shopService.getOrder(orderId1);

        //THEN
        //Ergebnisse vergleichen - result mit Order mit der Id 1
        assertEquals(expectedOrder, result);

        // Wurde eine bestimmte Methode aufgerufen?
        verify(orderRepository).get(orderId1);

    }

    @Test
    void addOrder_shouldAddOrder_whenOrderIsValid() {

        //GIVEN
        String orderId1 = "1";

        List<String > ids = Collections.emptyList();
        Order orderExpected = new Order(orderId1, Collections.emptyList());

                when(shopService.addOrder(orderId1, ids)).thenReturn(orderExpected);

        // WHEN
        Order result = shopService.addOrder(orderId1,ids);

        //THEN
        assertEquals(orderExpected, result);





    }
}