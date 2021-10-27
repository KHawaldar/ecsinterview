package com.ecs.service.implementor;
import com.ecs.common.FileUtility;
import com.ecs.domain.CarDetailEntity;
import com.ecs.exceptions.CarDetailNotFoundException;
import com.ecs.service.adapter.CarDetailService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultCarDetailService implements CarDetailService {
    private static Logger LOGGER = LoggerFactory.getLogger(DefaultCarDetailService.class);
    @Value("${project.installed.location}")
    private String projectHomeDirectory;

    @Override
    public List<CarDetailEntity> getCarDetail(String carModelId) {
        List<CarDetailEntity> carDetailEntityList = FileUtility.loadData(
                projectHomeDirectory.concat("/carapi/src/main/resources/cardetail.json")
                );
        return carDetailEntityList.stream().
                filter(carDetail -> carDetail.getCarModelId().equals(carModelId)).
                collect(Collectors.toList());
    }

    @Override
    public void update(CarDetailEntity carDetailEntity) throws CarDetailNotFoundException {
        try {
            //get the carDetailId from the persistent storage, file
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

            //Read the existing data from the file.
            InputStream in = new FileInputStream(projectHomeDirectory.concat("/carapi/src/main/resources/cardetail.json"));
            TypeReference<LinkedList<CarDetailEntity>> mapType = new TypeReference<LinkedList<CarDetailEntity>>(){};
            LinkedList<CarDetailEntity>carDetailEntityList = objectMapper.readValue(in,mapType);


            Optional<CarDetailEntity> carDetailOptional = carDetailEntityList.stream().
                    filter(a->a.getCarDetailId().equals(carDetailEntity.getCarDetailId()))
                    .findAny();
            //delete the existing object , but if it is database, you can update the object directly, no need to remove it.
            if(carDetailOptional.isPresent()){
                carDetailEntityList.remove(carDetailOptional.get());
                carDetailEntityList.add(carDetailEntity); //adding the new entry
            }else
            {
                throw new CarDetailNotFoundException();
            }
            //update it
            String jsonData = objectMapper.writeValueAsString(carDetailEntityList);
            Files.writeString(Paths.get(projectHomeDirectory.concat("/carapi/src/main/resources/cardetail.json")), jsonData);

        }catch(Exception e) {
            LOGGER.error("exception occured when updating car id {}", carDetailEntity.getCarDetailId(), e.getMessage());
            throw new CarDetailNotFoundException();
        }

    }

    public void save(CarDetailEntity carDetail ) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

            //Read the existing data from the file.
            InputStream in = new FileInputStream(getClass().getClassLoader().getResource("cardetail.json").getFile());
            TypeReference<List<CarDetailEntity>> mapType = new TypeReference<List<CarDetailEntity>>(){};
            List<CarDetailEntity>carDetailEntityList = objectMapper.readValue(in,mapType);
            carDetailEntityList.add(carDetail);

            String jsonData = objectMapper.writeValueAsString(carDetailEntityList);
            Files.writeString(Paths.get(  projectHomeDirectory.concat("/carapi/src/main/resources/cardetail.json")), jsonData);

        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
