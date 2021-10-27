package com.ecs.service.adapter;

import com.ecs.domain.CarDetailEntity;
import com.ecs.exceptions.CarDetailNotFoundException;

import java.util.List;

public interface CarDetailService {
    public void save(CarDetailEntity carDetail);
    public void update(CarDetailEntity carDetailId) throws CarDetailNotFoundException;
    public List<CarDetailEntity> getCarDetail(String carModelId);
}
