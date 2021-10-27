package com.ecs.service.implementor;


import com.ecs.domain.CarDetailEntity;
import com.ecs.exceptions.CarDetailNotFoundException;
import com.ecs.service.adapter.CarDetailService;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


public class DefaultCarDetailServiceTest extends ServiceTest{


    @Autowired
    CarDetailService carDetailService;
   // CarDetailService carDetailService = new DefaultCarDetailService();

    @Test
    public void testCarDetailNotFound() throws Exception {
           List<CarDetailEntity> carDetailEntityList =  carDetailService.getCarDetail("00000");
           Assertions.assertTrue(carDetailEntityList.size() == 0, "car detail is not empty.");

    }

    @Test
    public void testCarDetailFound() throws Exception {
        List<CarDetailEntity> carDetailEntityList =  carDetailService.getCarDetail("2");
        Assertions.assertTrue(carDetailEntityList.size() >0, "car detail is not found.");

    }


}
