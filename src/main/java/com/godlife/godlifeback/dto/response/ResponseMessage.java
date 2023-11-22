package com.godlife.godlifeback.dto.response;

public interface ResponseMessage {

    String SUCCESS = "Success.";

    String VALIDATION_FAILED = "Validation Failed.";
  
    String EMAIL_NOT_FOUND= "Email not found.";

    String DUPLICATED_EMAIL = "Duplicated email.";
    String DUPLICATED_NICKNAME = "Duplicated nickname.";
    String DUPLICATED_TEL_NUMBER = "Duplicate telephone number.";
    String DUPLICATED_PASSWORD = "Duplicated Password.";
    String DUPLICATED_CATEGORY = "Duplicated category."; 

    String SIGN_IN_FAILED = "Login information mismatch";
    String NOT_EXIST_USER = "This user does exist";
    String NOT_EXIST_USER_TO_DO_LIST = "This user to do list does exist";
    String NOT_EXIST_STUDY_MATERIAL = "This Study Material Number does not exist.";
    String NOT_EXIST_USER_LIST = "This User List Number does not exist.";
    String NOT_EXIST_BOARD = "This board does not exist.";
    String NOT_JOIN_USER = "This user is not join in the study room.";
  
    String NOT_NOTICE_EXISTS = "This notice does not exist.";
    String NOT_TODOLIST_EXISTS = "This study todolist does not exist.";
    String NOT_MATERIAL_EXISTS = "This study material comment does not exist.";
  
    String CANT_STUDY_DATE_MODIFY = "The next study date cannot be set to earlier than today.";
    String PASS_FAILED = "Confirm Password error.";
    String NO_PERMISSION = "Do not have permission.";
    String DATABASE_ERROR = "DataBase error.";
}