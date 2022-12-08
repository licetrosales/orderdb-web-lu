package com.github.licetrosales.orderdbweblu.controller;

import com.github.licetrosales.orderdbweblu.model.Product;
import com.github.licetrosales.orderdbweblu.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Wir schreiben einen Integrationsteset und stellen sicher dass
//- die HTTP Methoden ausgeführt werden
// -der Service läuft
// -das Repo die Daten hergibt

@SpringBootTest
@AutoConfigureMockMvc
class ShopControllerIntegrationTest {
    // Mock = So wie Nacmachen
    // MockMvc ermöglicht uns Anfragen nachzumachen
    // mockMvc ist null - wir müssen die Abhängigkeit, d.h. die DEPENDENCY bereitstellen
    @Autowired
    MockMvc mockMvc;
    // Wenn keine Produckte in der datenbank, dann gib leere Liste
    //mit when Muster
    @Autowired
    ProductRepository productRepository;

    @Test
    void getAllProducts_whenNoProductsInDB_thenReturnExmptyList() throws Exception {
        //Wir wollen die Endpunkte des ShopControllers testen
        //Z.B:
        //www.user-shop.de/shop/products

        //Gewünschetes Ergebnis: []
        // D.h. eine leere Liste

        mockMvc.perform(get("/shop/products"))
                .andExpect(status().isOk())
                // Wir erwarten ein JSON
                //* Ein Textformat um Objeckte darzustellen
                //Wir nutzen die drei Anführungsstriche,
                //um einen String über mehrere Zeile darzustellen

                //Es ist KEIN JSON
                // ... wir _benutzen_ es aber für JSON

                .andExpect(content().json(
                        """
                                []
                                """));

    }

    @Test
    void getAllProducts_ShouldReturnProductsListWithSingleProduct() throws Exception {
        Product product1 = new Product(null, null);
        productRepository.list().add(product1);

        mockMvc.perform(get("/shop/products"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                        {"name" : null,
                        "id": null
                        }
                        ]
                        """));

    }
}