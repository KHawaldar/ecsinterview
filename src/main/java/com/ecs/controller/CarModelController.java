package com.ecs.controller;

import com.ecs.api.model.CarMaker;
import com.ecs.api.model.CarModel;
import com.ecs.api.model.resources.CarModelResource;
import com.ecs.assembler.CarMakerAssembler;
import com.ecs.assembler.CarModelAssembler;
import com.ecs.domain.CarModelEntity;
import com.ecs.exceptions.ModelNotFoundException;
import com.ecs.service.adapter.CarModelService;
import com.ecs.service.adapter.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarModelController implements CarModelResource {
    @Autowired
    CarModelService carService;
    @Autowired
    CarModelAssembler carModelAssembler;
    @Override
    public ResponseEntity<CollectionModel<CarModel>> getCarModels(String carmakerId) {
      List<CarModelEntity> carModelEntityList =  carService.getCarModel(carmakerId);
      HttpStatus status =  carModelEntityList.isEmpty()? HttpStatus.NOT_FOUND:HttpStatus.OK;
      if(carModelEntityList.isEmpty()) {
          throw new ModelNotFoundException();
      }
       return new  ResponseEntity<>(carModelAssembler.toCollectionModel(carModelEntityList), HttpStatus.OK);
    }
}
