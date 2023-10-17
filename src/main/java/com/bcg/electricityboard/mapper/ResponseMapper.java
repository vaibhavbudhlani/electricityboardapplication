package com.bcg.electricityboard.mapper;

import com.bcg.electricityboard.model.Records;
import com.bcg.electricityboard.model.RecordsEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseMapper {

    public Records mapRecords(RecordsEntity recordsEntity) {
        Records records = new Records();
        records.setId(recordsEntity.getId());
        records.setCategory(recordsEntity.getCategory());
        records.setDistrict(recordsEntity.getDistrict());
        records.setGender(recordsEntity.getGender());
        records.setApplicantName(recordsEntity.getApplicantName());
        records.setGovtId(recordsEntity.getGovtId());
        records.setPincode(recordsEntity.getPincode());
        records.setDateOfApplication(String.valueOf(recordsEntity.getDateOfApplication()));
        records.setLoad_applied(recordsEntity.getLoad_applied());
        records.setDateOfApproval(String.valueOf(recordsEntity.getDateOfApproval()));
        records.setModifiedDate(String.valueOf(recordsEntity.getModifiedDate()));
        records.setState(recordsEntity.getState());
        records.setStatus(recordsEntity.getStatus());
        records.setIdNumber(recordsEntity.getIdNumber());
        records.setReveiwerId(recordsEntity.getReveiwerId());
        records.setReveiwerName(recordsEntity.getReveiwerName());
        records.setReviewercomments(recordsEntity.getReviewercomments());
        records.setOwnership(recordsEntity.getOwnership());
        return records;

    }
}
