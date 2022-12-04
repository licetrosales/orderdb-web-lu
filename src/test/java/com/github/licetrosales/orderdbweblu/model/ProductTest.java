package com.github.licetrosales.orderdbweblu.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testRecord(){
        Product product1 = new Product("Hat", "1");
        Product product2 = new Product("Pullover", "2");

        // attribute
        System.out.println(product1.id());
        System.out.println(product1.name());

        // to_String methode test
        System.out.println(product2);

        System.out.println(product1.equals(product2));

        // copy generation
        Product copy = new Product(product2.name() + "copy", product2.id());
        System.out.println(copy);


    }


}