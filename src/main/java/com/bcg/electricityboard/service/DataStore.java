package com.bcg.electricityboard.service;

import com.bcg.electricityboard.model.RecordsEntity;
import com.bcg.electricityboard.repository.DataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Component
public class DataStore {

    Logger logger = LoggerFactory.getLogger(DataStore.class);
    @Autowired
    private DataRepository dataRepository;
    List<RecordsEntity> records = new ArrayList<>();



    public void setRecords(){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            RecordsEntity[] entities = objectMapper.readValue(new File("src/main/resources/records.json"),
                    RecordsEntity[].class);
            logger.debug("File is "+entities);
            records = Arrays.asList(entities);

            List<RecordsEntity> savedRecords = dataRepository.saveAll(records);
            logger.debug("Records are "+savedRecords);
        } catch (IOException e) {

            logger.error("Coming inside Catch block ",e);
        }
    }
    public List<RecordsEntity> getAllRecords() {
        return this.records;
    }






}
