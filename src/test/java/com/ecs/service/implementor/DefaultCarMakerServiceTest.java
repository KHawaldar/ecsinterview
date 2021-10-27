package com.ecs.service.implementor;

import com.ecs.domain.CarMakerEntity;
import com.ecs.service.adapter.CarMakerService;
import com.ecs.service.adapter.CarModelService;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;

public class DefaultCarMakerServiceTest extends ServiceTest{

    @Autowired
    CarMakerService carMakerService;

    @Test
    public void testGetCarMakerEntityIsNotFound() throws Exception {
        Optional<CarMakerEntity> carMakerEntity =  carMakerService.getCarMakerEntity("100");
        assertThat("car model is not empty", carMakerEntity.isEmpty());

    }
    @Test
    public void testGetCarMakerEntityIsFound() throws Exception {
        Optional<CarMakerEntity> carMakerEntity =  carMakerService.getCarMakerEntity("1");
        assertThat("car model is empty", carMakerEntity.get() instanceof CarMakerEntity);

    }

    @Test
    public void testGetCarMakers() throws Exception {
        List<CarMakerEntity> carMakerEntity =  carMakerService.getCarMakers();
         Assertions.assertThat( Matchers.allOf(
                Matchers.hasItems(carMakerEntity.get(0)),
                Matchers.hasItems(carMakerEntity.get(1))
        ));
    }

}
