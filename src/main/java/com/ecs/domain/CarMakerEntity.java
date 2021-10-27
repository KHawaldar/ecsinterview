package com.ecs.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarMakerEntity {

    private String carmakerId = null;
    private String makercode = null;
    private String make = null;
    private UUID syncGuid = null;
    private Boolean isDeleted = Boolean.FALSE;
    private List<CarModelEntity> carModelEntityList;
}
