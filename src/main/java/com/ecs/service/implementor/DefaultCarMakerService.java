package com.ecs.service.implementor;

import com.ecs.domain.CarMakerEntity;
import com.ecs.service.adapter.CarMakerService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultCarMakerService implements CarMakerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultCarMakerService.class);
    private final ObjectMapper objectMapper = new ObjectMapper();


    public List<CarMakerEntity> getCarMakers() {

        List<CarMakerEntity> carMakerEntity = null;

        try {
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            //data is stored in file
            InputStream in = new FileInputStream(getClass().getClassLoader().getResource("carmaker.json").getFile());
            TypeReference<List<CarMakerEntity>> mapType = new TypeReference<List<CarMakerEntity>>() {
            };
            carMakerEntity = objectMapper.readValue(in, mapType);

        } catch (Exception e) {
            LOGGER.error("file is not found " + e.getMessage());
        }
        return carMakerEntity;
    }

    @Override
    public Optional<CarMakerEntity> getCarMakerEntity(String carMakerId) {

        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        CarMakerEntity carMakerEntity = null;
        Optional<CarMakerEntity> carMakerOptional = Optional.empty();
        try {
                InputStream in = new FileInputStream(getClass().getClassLoader().getResource("carmaker.json")
                        .getFile());
                TypeReference<List<CarMakerEntity>> mapType = new TypeReference<List<CarMakerEntity>>() {
                };
                List<CarMakerEntity> carMakerEntityList = objectMapper.readValue(in, mapType);
                carMakerOptional = carMakerEntityList.stream()
                        .filter(a -> a.getCarmakerId().equalsIgnoreCase(carMakerId))
                        .findAny();

        } catch (IOException excep) {
            LOGGER.error("file is not found " + excep.getMessage());
        }
        return carMakerOptional;
    }

}
