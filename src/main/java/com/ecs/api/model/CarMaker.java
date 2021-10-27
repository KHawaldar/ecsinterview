package com.ecs.api.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.UUID;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarMaker extends RepresentationModel<CarMaker> {

    private String carmakerId = null;
    private String makercode = null;
    private String make = null;
    private UUID syncGuid = null;
    List<CarModel> carModels;
}

