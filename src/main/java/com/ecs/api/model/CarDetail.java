package com.ecs.api.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDetail extends RepresentationModel<CarDetail> {
    private String carDetailId;
    private String carModelId;
    private Integer year;
    private String colour;
    private UUID syncGuid;
}
