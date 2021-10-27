package com.ecs.controller;

import com.ecs.api.model.CarDetail;
import com.ecs.exceptions.CarDetailNotFoundException;
import org.junit.jupiter.api.Test;

public class CarDetailControllerTest extends ControllerTest{

    @Test
    public void testSave(){
        CarDetail carDetail = CarDetail.builder()
                .carDetailId("1000")
                .carModelId("1")
                .colour("green")
                .year(2020)
                .build();
        this.webClient.post().uri("/ecs/carapi/v1/cardetail")
                .bodyValue(carDetail)
                .exchange()
                .expectStatus().isCreated();

    }

    @Test
    public void testGetCarDetailNotFound(){
        this.webClient.get().uri("/ecs/carapi/v1/model/0000/getcardetail")
                 .exchange()
                 .expectStatus().isNotFound();
    }

    @Test
    public void testGetCarDetailFound(){
        this.webClient.get().uri("/ecs/carapi/v1/model/2/getcardetail")
                .exchange()
                .expectStatus().is2xxSuccessful();
    }

    @Test
    public void testUpdate(){


        CarDetail carDetail = CarDetail.builder()
                .carDetailId("2")
                .carModelId("2")
                .colour("xxxxxxxxxxxxxxx")
                .year(2032)
                .build();

        this.webClient.put().uri("/ecs/carapi/v1/carupdate/")
                .bodyValue(carDetail)
                .exchange()
                .expectStatus().is2xxSuccessful();
    }


}
