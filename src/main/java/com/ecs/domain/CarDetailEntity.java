package com.ecs.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDetailEntity {

    private String carDetailId = null;
    private String carModelId = null;
    private Integer year = null;
    private String colour = null;
    private UUID syncGuid = null;
}
