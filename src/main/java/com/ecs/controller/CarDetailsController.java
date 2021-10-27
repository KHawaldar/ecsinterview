package com.ecs.controller;

import com.ecs.api.model.CarDetail;
import com.ecs.api.model.resources.CarDetailResource;
import com.ecs.assembler.CarDetailAssembler;
import com.ecs.domain.CarDetailEntity;
import com.ecs.exceptions.CarDetailNotFoundException;
import com.ecs.service.adapter.CarDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CarDetailsController implements CarDetailResource {

    @Autowired
    CarDetailService carService;
    @Autowired
    CarDetailAssembler carDetailAssembler;

    @Override
    public ResponseEntity<String> save (CarDetail carDetail) {
        CarDetailEntity carDetailEntity = carDetailAssembler.toEntity(carDetail);
        carService.save(carDetailEntity);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> update(CarDetail carDetail) {
        CarDetailEntity carDetailEntity = carDetailAssembler.toEntity(carDetail);
        carService.update(carDetailEntity);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CollectionModel<CarDetail>> getCardetails(String modelId) {
        List<CarDetailEntity> carDetailEntityList = carService.getCarDetail(modelId);
        if(carDetailEntityList.isEmpty()) {
            throw new CarDetailNotFoundException("Car is not found");
        }
        return new  ResponseEntity<>(carDetailAssembler.toCollectionModel(carDetailEntityList), HttpStatus.OK);
    }
}
