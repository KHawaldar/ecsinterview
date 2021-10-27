package com.ecs.controller;
import com.ecs.api.model.CarMaker;
import com.ecs.api.model.resources.CarMakerResource;
import com.ecs.assembler.CarMakerAssembler;
import com.ecs.domain.CarMakerEntity;
import com.ecs.service.adapter.CarMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Optional;

@Controller
public class CarMakerController implements CarMakerResource {

    @Autowired
    CarMakerService carService;
    @Autowired
    CarMakerAssembler carMakerAssembler;

    @Override
    public ResponseEntity<CollectionModel<CarMaker>> getCarMakers() {
        List<CarMakerEntity> carMakerEntity = carService.getCarMakers();
        return new ResponseEntity<>(carMakerAssembler.toCollectionModel(carMakerEntity), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<CarMaker> getCarMakerById(String carmakerId) {
           Optional<CarMakerEntity> carMakerEntity = carService.getCarMakerEntity(carmakerId);
           if(carMakerEntity.isPresent()) {
               return new ResponseEntity<>(carMakerAssembler.toModel(carMakerEntity.get()),HttpStatus.OK );
           }else{
               return new ResponseEntity<>(carMakerAssembler.toModel(carMakerEntity.get()),HttpStatus.NOT_FOUND );
           }

    }
}
