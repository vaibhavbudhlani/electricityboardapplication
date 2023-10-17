package com.bcg.electricityboard.mapper;

import com.bcg.electricityboard.model.Records;
import com.bcg.electricityboard.model.RecordsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class RequestMapper {

    Logger logger = LoggerFactory.getLogger(RequestMapper.class);

    public RecordsEntity mapRecords(Records recordsEntity) {


        RecordsEntity records = new RecordsEntity();
        records.setId(recordsEntity.getId());
        records.setCategory(recordsEntity.getCategory());
        records.setDistrict(recordsEntity.getDistrict());
        records.setGender(recordsEntity.getGender());
        records.setApplicantName(recordsEntity.getApplicantName());
        records.setGovtId(recordsEntity.getGovtId());
        records.setPincode(recordsEntity.getPincode());
         records.setDateOfApplication(doOperations(recordsEntity.getDateOfApplication()));
         records.setDateOfApproval(doOperations(recordsEntity.getDateOfApproval()));
         records.setModifiedDate(doOperations(recordsEntity.getModifiedDate()));
        records.setLoad_applied(recordsEntity.getLoad_applied());

        records.setState(recordsEntity.getState());
        records.setStatus(recordsEntity.getStatus());
        records.setIdNumber(recordsEntity.getIdNumber());
        records.setReveiwerId(recordsEntity.getReveiwerId());
        records.setReveiwerName(recordsEntity.getReveiwerName());
        records.setReviewercomments(recordsEntity.getReviewercomments());
        records.setOwnership(recordsEntity.getOwnership());
        return records;

    }

    private  Date doOperations(String dateString){

        SimpleDateFormat[] dateFormats = {

                new SimpleDateFormat("yyyy-MM-dd"),
                new SimpleDateFormat("MM/dd/yyyy"),
                new SimpleDateFormat("dd-MMM-yyyy"),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
                new SimpleDateFormat("EEEE, MMMM dd, yyyy"),
                new SimpleDateFormat("dd-M-yy"),
                new SimpleDateFormat("YYYY-MM-DD")
        };


            try {
                for (SimpleDateFormat format : dateFormats) {

                    Date date = format.parse(dateString);

                    logger.debug("Parsed Date: " + date);
                    return date;
                }

            } catch (Exception e) {

                logger.error("Error occurred in mapping ",e);

            }


        return null;
    }
}
