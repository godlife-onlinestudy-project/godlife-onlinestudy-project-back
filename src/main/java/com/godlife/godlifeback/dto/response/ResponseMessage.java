package com.godlife.godlifeback.dto.response;

public interface ResponseMessage {

    String SUCCESS = "Succss.";

    String VALIDATION_FAILED = "Validation failed.";
    String DUPLICATED_EMAIL = "Duplicate email.";
    String DUPLICATED_NICKNAME = "Duplicate nickname.";
    String DUPLICATED_FAVORITE1 = "Duplicate Favorite1.";

    String EMAIL_NOT_FOUND= "Email not found.";
    String DUPLICATED_PASSWORD = "Duplicated Password.";
    String DUPLICATED_CATEGORY = "Duplicated category."; 

    String SIGN_IN_FAILED = "Login information mismatch";

    String NOT_EXIST_USER = "This user does not exist.";
    String NOT_EXIST_USER_TO_DO_LIST = "This user to do list does exist";
    String NOT_EXIST_USER_LIST = "This User List Number does not exist.";
    String NOT_EXIST_BOARD = "This board does not exist.";
    String NOT_EXIST_STUDY = "This study does not exist.";
    String NOT_EXIST_STUDY_MATERIAL = "This Study Material Number does not exist.";
    String NOT_EXIST_TODOLIST = "This study todolist does not exist.";
    String NOT_EXIST_NOTICE = "This notice does not exist.";
    String NOT_EXIST_MATERIAL = "This study material comment does not exist.";
    String NO_PERMISSION = "Do not have permission.";
    String PASS_FAILED = "Confirm Password error.";

    String DATABASE_ERROR = "DataBase error.";

    String CANT_STUDY_DATE_MODIFY = "The next study date cannot be set to earlier than today.";
    String NOT_JOIN_USER = "This user is not join in the study room.";
}
