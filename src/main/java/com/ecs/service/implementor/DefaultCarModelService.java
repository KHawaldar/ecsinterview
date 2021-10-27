package com.ecs.service.implementor;
import com.ecs.domain.CarModelEntity;
import com.ecs.service.adapter.CarModelService;
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
import java.util.stream.Collectors;

@Service
public class DefaultCarModelService implements CarModelService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultCarModelService.class);
    private  ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<CarModelEntity> getCarModel(String carMakerId) {
        List<CarModelEntity> carModelEntityList = null;
        List<CarModelEntity> carModelResult = null;
        try {

            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            InputStream in = new FileInputStream(getClass().getClassLoader().getResource("carmodel.json").getFile());
            TypeReference<List<CarModelEntity>> mapType = new TypeReference<List<CarModelEntity>>(){};
            carModelEntityList = objectMapper.readValue(in,mapType);

            carModelResult = carModelEntityList.stream()
                    .filter(a -> a.getCarmakerId().equals(carMakerId) )
                    .collect(Collectors.toList());


        }catch(IOException e) {
            LOGGER.error("file is not found " + e.getMessage());

        }
        return carModelResult;

    }
}
