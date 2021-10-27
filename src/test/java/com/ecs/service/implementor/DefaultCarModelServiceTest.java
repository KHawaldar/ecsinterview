package com.ecs.service.implementor;
import com.ecs.domain.CarModelEntity;
import com.ecs.service.adapter.CarModelService;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class DefaultCarModelServiceTest extends ServiceTest{

    @Autowired
    CarModelService carModelService;

    @Test
    public void testGetCarModel() throws Exception {
        List<CarModelEntity> carModelEntity = carModelService.getCarModel("1");
        Assertions.assertThat( Matchers.allOf(
                Matchers.hasItem(carModelEntity.get(0)),
                Matchers.hasItem(carModelEntity.get(1))
        ));
    }
}
