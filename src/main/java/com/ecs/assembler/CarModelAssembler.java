package com.ecs.assembler;
import com.ecs.api.model.CarModel;
import com.ecs.controller.CarModelController;
import com.ecs.domain.CarModelEntity;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CarModelAssembler extends RepresentationModelAssemblerSupport<CarModelEntity, CarModel> {

    public CarModelAssembler() {
        super(CarModelController.class, CarModel.class);
    }

    @Override
    public CarModel toModel(CarModelEntity entity) {

        CarModel carModel = CarModel.builder()
                .model(entity.getModel())
                .carModelId(entity.getCarmodelId())
                .modelCode(entity.getModelCode())
                .carmakerId(entity.getCarmakerId())
                .build()
                .add(linkTo(
                    methodOn(CarModelController.class)
                   .getCarModels(entity.getCarmakerId()))
                .withSelfRel());

        return carModel;
    }
    @Override
    public CollectionModel<CarModel> toCollectionModel(Iterable<? extends CarModelEntity> entities){

        CollectionModel<CarModel> actorModels = super.toCollectionModel(entities);
         actorModels.getContent().stream().
                map(a-> actorModels.add(linkTo(methodOn(CarModelController.class).
                                    getCarModels(a.getCarmakerId().toString())).withSelfRel())

                   );
        return actorModels;
    }
}
