package com.godlife.godlifeback.dto.response;

public interface ResponseMessage {

    String SUCCESS = "Success.";

    String VALIDATION_FAILED = "Validation Failed.";

    String DUPLICATED_EMAIL = "Duplicated email.";
    String DUPLICATED_NICKNAME = "Duplicated nickname.";
    String DUPLICATED_TEL_NUMBER = "Duplicate telephone number.";
    String DUPLICATED_PASSWORD = "Duplicated Password.";
    String DUPLICATED_CATEGORY = "Duplicated category."; 

    String SIGN_IN_FAILED = "Login information mismatch";
    String NOT_EXIST_USER = "This user does exist";
    String NOT_EXIST_BOARD = "This board does not exist.";
    String PASS_FAILED = "Confirm Password error.";
    String NO_PERMISSION = "Do not have permission.";
    String DATABASE_ERROR = "DataBase error.";

}