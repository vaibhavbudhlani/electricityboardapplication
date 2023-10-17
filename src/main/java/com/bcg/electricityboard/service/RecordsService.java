package com.bcg.electricityboard.service;

import com.bcg.electricityboard.Exception.RecordNotFoundException;
import com.bcg.electricityboard.mapper.RequestMapper;
import com.bcg.electricityboard.mapper.ResponseMapper;
import com.bcg.electricityboard.model.Records;
import com.bcg.electricityboard.model.RecordsEntity;
import com.bcg.electricityboard.model.RecordsInput;
import com.bcg.electricityboard.repository.DataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class RecordsService {

    Logger logger = LoggerFactory.getLogger(RecordsService.class);
    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private ResponseMapper responseMapper;
    @Autowired
    private RequestMapper requestMapper;

    public float saveRecords(RecordsInput records){
        Records records1 = new Records();
        BeanUtils.copyProperties(records,records1);
        return dataRepository.save(requestMapper.mapRecords(records1)).getIdNumber();
    }

    public float updateRecord(RecordsInput records) throws RecordNotFoundException {
        Records records1 = new Records();
        BeanUtils.copyProperties(records,records1);
        RecordsEntity entity = dataRepository.findByIdNumber(records1.getIdNumber());
        if(Objects.isNull(entity)){
            entity = new RecordsEntity();
        }
        entity.setApplicantName(records.getApplicantName());
        entity.setStatus(records.getStatus());
        return dataRepository.save(entity).getIdNumber();

    }

    public List<Records> getAllRecords() throws RecordNotFoundException {
        List<RecordsEntity> recordsEntityList = dataRepository.findAll();
        return recordsEntityList.stream().map(responseMapper::mapRecords).collect(Collectors.toList());
    }

    public Records getRecordById(float id) throws RecordNotFoundException {
        RecordsEntity entity = dataRepository.findByIdNumber(id);
        if(Objects.nonNull(entity))
        {
            return responseMapper.mapRecords(entity);
        }
        else{
            throw new RecordNotFoundException("Records Not found");
        }

    }

    public List<Records> recordsBetweenDateRange(String startDateS,String endDateS) throws RecordNotFoundException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yy");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sdf.parse(startDateS);
            endDate = sdf.parse(endDateS);
        } catch (ParseException e) {
            logger.error("Parsing Exception occured",e);
        }

        List<RecordsEntity> recordsEntityList = dataRepository.findByDateOfApplicationBetween( startDate,  endDate);
        if(Objects.nonNull(recordsEntityList)){
            return recordsEntityList.stream().map(responseMapper::mapRecords).collect(Collectors.toList());
        }
        else{
            throw new RecordNotFoundException("Records Not found");
        }
    }




}
