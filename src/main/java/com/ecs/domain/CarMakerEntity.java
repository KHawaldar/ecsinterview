package com.ecs.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty
    private String carmakerId = null;
    @JsonProperty
    private String makercode = null;
    @JsonProperty
    private String make = null;
    private UUID syncGuid = null;
    @JsonProperty
    private Boolean isDeleted = Boolean.FALSE;


    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @JsonProperty
    private List<CarModelEntity> carModelEntityList;

    public List<CarModelEntity> getCarModelEntityList() {
        return carModelEntityList;
    }

    public void setCarModelEntityList(List<CarModelEntity> carModelEntityList) {
        this.carModelEntityList = carModelEntityList;
    }

    public String getCarmakerId() {
        return carmakerId;
    }

    public void setCarmakerId(String carmakerId) {
        this.carmakerId = carmakerId;
    }

    public String getMakercode() {
        return makercode;
    }

    public void setMakercode(String makercode) {
        this.makercode = makercode;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public UUID getSyncGuid() {
        return syncGuid;
    }

    public void setSyncGuid(UUID syncGuid) {
        this.syncGuid = syncGuid;
    }


}
