package com.bcg.electricityboard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecordsInput {

    private int id;

    private String applicantName;

    private String gender;

    private String district;

    private String state;

    private int pincode;

    private String ownership;

    private String govtId;

    private float idNumber;
    private String category;
    private int load_applied;

    private String dateOfApplication;

    private String dateOfApproval;

    private String modifiedDate;
    private String status;
    private int reveiwerId;
    private String reveiwerName;
    private String reviewercomments;





}
