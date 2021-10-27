package com.ecs.service.adapter;

import com.ecs.domain.CarModelEntity;

import java.util.List;

public interface CarModelService {
    public List<CarModelEntity> getCarModel(String carMakerId);
}
