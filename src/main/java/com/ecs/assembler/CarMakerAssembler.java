package com.ecs.assembler;
import com.ecs.api.model.CarMaker;
import com.ecs.api.model.CarModel;
import com.ecs.controller.CarMakerController;
import com.ecs.controller.CarModelController;
import com.ecs.domain.CarMakerEntity;
import com.ecs.domain.CarModelEntity;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarMakerAssembler extends RepresentationModelAssemblerSupport<CarMakerEntity, CarMaker> {

    public CarMakerAssembler()   {
        super(CarMakerController.class, CarMaker.class);
    }

    @Override
    public CarMaker toModel(CarMakerEntity entity){

        CarMaker carMaker = CarMaker.builder().build();
        carMaker.add(linkTo(
                    methodOn(CarMakerController.class)
                    .getCarMakers())
                    .withSelfRel());
        carMaker.setMakercode(entity.getMakercode());
        carMaker.setMake(entity.getMake());
        carMaker.setCarModels(getCarModelLink(entity.getCarModelEntityList()));
        return carMaker;
    }

    private List<CarModel> getCarModelLink(List<CarModelEntity> carModelEntities) {

        return carModelEntities.stream()
                .map(carModel -> CarModel.builder()
                        .model(carModel.getModel())
                        .modelCode(carModel.getModelCode())
                        .carModelId(carModel.getCarmodelId())
                        .carmakerId(carModel.getCarmakerId())
                        .build()
                        .add(linkTo(
                                methodOn(CarModelController.class)
                                .getCarModels(carModel.getCarmakerId()))
                                .withSelfRel()))
                .collect(Collectors.toList());

    }

    public CarMakerEntity transformCarMakerModelToEntity(CarMaker carMaker){

        return  CarMakerEntity.builder()
                .carmakerId(carMaker.getCarmakerId())
                .make(carMaker.getMake())
                .carModelEntityList(
                        carMaker.getCarModels().stream()
                                .map(a-> CarModelEntity.builder()
                                        .carmodelId(a.getCarModelId())
                                        .build())
                                .collect(Collectors.toList())
                )
                .build();
    }

    @Override
    public CollectionModel<CarMaker> toCollectionModel(Iterable<? extends CarMakerEntity> entities){

        CollectionModel<CarMaker> actorModels = super.toCollectionModel(entities);
       actorModels.add(linkTo(methodOn(CarMakerController.class).getCarMakers()).withSelfRel());

       // actorModels.add(linkTo(methodOn(CarModelController.class).getCarMakers()).withSelfRel());
    /*  actorModels.getContent().stream().
                map(a-> actorModels.add(linkTo(methodOn(CarModelController.class).
                        getCarModels(
                                a.getCarmakerId().toString())).withSelfRel()));
*/


        return actorModels;
    }
}
