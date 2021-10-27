package com.ecs.common;

import com.ecs.domain.CarDetailEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class FileUtility {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtility.class);
    private FileUtility(){}
    public static List<CarDetailEntity> loadData(final String fileName){

            ObjectMapper objectMapper = new ObjectMapper();
            List<CarDetailEntity> carDetailEntityList = null;
            try {
                InputStream in = new FileInputStream(fileName);
                TypeReference<List<CarDetailEntity>> mapType = new TypeReference<List<CarDetailEntity>>() { };
                carDetailEntityList = objectMapper.readValue(in, mapType);
            }catch(IOException ioException) {
                LOGGER.error("Exception while loading the data {}",ioException.getMessage());
            }
            return  carDetailEntityList;
        }

    /*
        public static <T> List<T> loadData(final String fileName, TypeReference  typeReference, Class<T> clazz){

        ObjectMapper objectMapper = new ObjectMapper();
        List<T> data = new ArrayList<T>();
        try {
            InputStream in = new FileInputStream(fileName);
            TypeReference<List<T>> mapType = new TypeReference<List<clazz>>() { };

            data = objectMapper.readValue(in, typeReference);
        }catch(IOException ioException) {
            LOGGER.error("Exception while loading the data {}",ioException.getMessage());
        }
        return  data;
    }*/

}
