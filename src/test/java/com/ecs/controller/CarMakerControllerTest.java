package com.ecs.controller;
import org.junit.jupiter.api.Test;

public class CarMakerControllerTest extends ControllerTest{

    @Test
    public void testGetCarMaker(){
        this.webClient.get().uri("/ecs/carapi/v1/getCarMakers")
                .exchange()
                .expectStatus().is2xxSuccessful();

    }
}
