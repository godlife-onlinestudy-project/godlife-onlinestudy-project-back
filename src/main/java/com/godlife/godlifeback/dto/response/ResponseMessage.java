package com.godlife.godlifeback.dto.response;

public interface ResponseMessage {
    
    String SUCCESS = "Success.";

    String VALIDATION_FAILED = "Validation failed.";
    String DUPLICATED_EMAIL = "Duplicate email.";
    String DUPLICATED_NICKNAME = "Duplicate nickname.";
    String DUPLICATED_TEL_NUMBER = "Duplicate telephone number.";
    String NOT_EXIST_USER = "This user does not exist.";
    String NOT_EXIST_BOARD = "This board does not exist.";

    String SIGN_IN_FAILED = "Login information mismatch.";

    String NO_PERMISSION = "Do not have permission.";

    String DATABASE_ERROR = "Database error.";

    String EMAIL_NOT_FOUND="Email not found.";
    String NOT_SAFE_PASSWORD = "Not safe password.";
    String NOT_EXIST_STUDY_MATERIAL = "This Study Material Number does not exist.";
    String NOT_EXIST_USER_LIST = "This User List Number does not exist.";
    String NOT_EXIST_STUDY_ROOM = "This study room does not exist.";
    String NOT_JOIN_USER = "This user is not join in the study room.";
    String CANT_STUDY_DATE_MODIFY = "The next study date cannot be set to earlier than today.";

    String NOT_NOTICE_EXISTS = "This notice does not exist.";
    String NOT_TODOLIST_EXISTS = "This study todolist does not exist.";
    String NOT_MATERIAL_EXISTS = "This study material comment does not exist.";

}
