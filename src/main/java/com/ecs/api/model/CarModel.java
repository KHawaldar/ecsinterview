package com.ecs.api.model;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Builder
public class CarModel extends RepresentationModel<CarModel> {

    private String carModelId = null;
    private String carmakerId = null;
    private String modelCode = null;
    private String model = null;
    private UUID syncGuid = null;
}
