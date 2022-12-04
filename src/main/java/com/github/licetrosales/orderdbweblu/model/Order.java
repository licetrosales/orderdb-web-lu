package com.github.licetrosales.orderdbweblu.model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

// @Data: Hier haben wir immer noch setter, getter, toString, equals
// @NoArgsConstructor & AllArgsConstructoren: Konstruktoren ohne und mit Parametern
public class Order {

    private String id;
    private List<Product> products;
}
