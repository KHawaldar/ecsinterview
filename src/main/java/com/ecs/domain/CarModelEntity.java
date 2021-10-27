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

public class CarModelEntity {

    private String carmodelId = null;
    private String carmakerId = null;
    private String modelCode = null;
    private String model = null;
    private UUID syncGuid = null;

}
