package com.ecs.assembler;

import com.ecs.api.model.CarDetail;
import com.ecs.api.model.CarMaker;
import com.ecs.api.model.CarModel;
import com.ecs.controller.CarDetailsController;
import com.ecs.controller.CarMakerController;
import com.ecs.controller.CarModelController;
import com.ecs.domain.CarDetailEntity;
import com.ecs.domain.CarMakerEntity;
import com.ecs.domain.CarModelEntity;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CarDetailAssembler  extends RepresentationModelAssemblerSupport<CarDetailEntity, CarDetail> {

    public CarDetailAssembler()   {
        super(CarDetailsController.class, CarDetail.class);
    }
    @Override
    public CarDetail toModel(CarDetailEntity entity) {
              return CarDetail.builder()
                      .carDetailId(entity.getCarDetailId())
                      .carModelId(entity.getCarModelId())
                      .colour(entity.getColour())
                      .year(entity.getYear())
                      .syncGuid(entity.getSyncGuid())
                      .build();
    }

    public CarDetailEntity toEntity(CarDetail carDetail){
        return CarDetailEntity.builder()
                .carDetailId(carDetail.getCarDetailId())
                .carModelId(carDetail.getCarModelId())
                .colour(carDetail.getColour())
                .year(carDetail.getYear())
                .syncGuid(carDetail.getSyncGuid())
                .build();
    }

    @Override
    public CollectionModel<CarDetail> toCollectionModel(Iterable<? extends CarDetailEntity> entities){

        CollectionModel<CarDetail> actorModels = super.toCollectionModel(entities);
        return actorModels;
    }

}

