package com.ecs.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty
    private String carmodelId = null;
    @JsonProperty
    private String carmakerId = null;
    @JsonProperty
    private String modelCode = null;
    @JsonProperty
    private String model = null;
    private UUID syncGuid = null;

  /*  public Integer getCarModelGroupByMakerId(){
        return  carmakerId;
    }*/

    public String getCarmodelId() {
        return carmodelId;
    }

    public void setCarmodelId(String carModelId) {
        this.carmodelId = carModelId;
    }

    public String getCarmakerId() {
        return carmakerId;
    }

    public void setCarmakerId(String carmakerId) {
        this.carmakerId = carmakerId;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public UUID getSyncGuid() {
        return syncGuid;
    }

    public void setSyncGuid(UUID syncGuid) {
        this.syncGuid = syncGuid;
    }
}
