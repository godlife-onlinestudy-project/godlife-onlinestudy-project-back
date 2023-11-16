package com.godlife.godlifeback.dto.response;

public interface ResponseMessage {

    String SUCCESS = "Succss.";

    String VALIDATION_FAILED = "Validation Failed.";

    String DUPLICATED_EMAIL = "Duplicated email.";
    String DUPLICATED_NICKNAME = "Duplicated nickname.";
    String DUPLICATED_PASSWORD = "Duplicated Password.";
    String DUPLICATED_CATEGORY = "Duplicated category."; 

    String SIGN_IN_FAILED = "Login information mismatch";
    String NOT_EXIST_USER = "This user does not exist.";
    String NOT_EXIST_STUDY = "This study does not exist.";
    String NOT_EXIST_STUDY_MATERIAL = "This Study Material Number does not exist.";
    String NO_PERMISSION = "Do not have permission.";
    String PASS_FAILED = "Confirm Password error.";

    String DATABASE_ERROR = "DataBase error.";

}
