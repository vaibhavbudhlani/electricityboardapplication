package com.bcg.electricityboard.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Records {
    @JsonProperty("ID")
    private int id;
    @JsonProperty("Applicant_Name")
    private String applicantName;
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("District")
    private String district;
    @JsonProperty("State")
    private String state;
    @JsonProperty("Pincode")
    private String pincode;
    @JsonProperty("Ownership")
    private String ownership;
    @JsonProperty("GovtID_Type")
    private String govtId;
    @JsonProperty("ID_Number")
    private float idNumber;
    @JsonProperty("Category")
    private String category;
    @JsonProperty("Load_Applied (in KV)")
    private int load_applied;
    @JsonProperty("Date_of_Application")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-M-yy")
    private String dateOfApplication;
    @JsonProperty("Date_of_Approval")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-M-yy")
    private String dateOfApproval;
    @JsonProperty("Modified_Date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-M-yy")
    private String modifiedDate;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Reviewer_ID")
    private String reveiwerId;
    @JsonProperty("Reviewer_Name")
    private String reveiwerName;
    @JsonProperty("Reviewer_Comments")
    private String reviewercomments;





}
