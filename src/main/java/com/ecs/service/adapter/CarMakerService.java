package com.ecs.service.adapter;

import com.ecs.domain.CarMakerEntity;
import java.util.List;
import java.util.Optional;

public interface CarMakerService {
    public List<CarMakerEntity> getCarMakers();
    public Optional<CarMakerEntity> getCarMakerEntity(String carMakerId);

}
