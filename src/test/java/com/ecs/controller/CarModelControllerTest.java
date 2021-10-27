package com.ecs.controller;
import org.junit.jupiter.api.Test;

public class CarModelControllerTest extends ControllerTest {

    @Test
    public void testGetCarModel(){
        this.webClient.get().uri("/ecs/carapi/v1/carmakers/2/model")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody();
    }
    @Test()
    public void testGetCarModelNotFound(){
        this.webClient.get().uri("/ecs/carapi/v1/carmakers/0000000/model")
                .exchange()
                .expectStatus().isNotFound();

    }

}

