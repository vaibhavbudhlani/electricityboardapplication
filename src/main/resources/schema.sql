DROP TABLE IF EXISTS RECORDS_TABLE;

CREATE TABLE RECORDS_TABLE (
    ID INT NOT NULL ,
    Applicant_Name VARCHAR(255),
    Gender VARCHAR(10),
    District VARCHAR(50),
    State VARCHAR(50),
    Pincode INT,
    Ownership VARCHAR(20),
    GovtID_Type VARCHAR(20),
    ID_Number INT NOT NULL PRIMARY KEY,
    Category VARCHAR(20),
    Load_Applied_KV INT,
    Date_of_Application DATE,
    Date_of_Approval DATE,
    Modified_Date DATE,
    Status VARCHAR(20),
    Reviewer_ID INT,
    Reviewer_Name VARCHAR(255),
    Reviewer_Comments TEXT
);
