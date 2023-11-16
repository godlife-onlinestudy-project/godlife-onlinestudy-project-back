package com.godlife.godlifeback.dto.response;

public interface ResponseCode {

    String SUCCESS = "SU";

    String VALIDATION_FAILED = "VF";

    String DUPLICATED_EMAIL = "DE";
    String DUPLICATED_TEL_NUMBER = "DT";
    String DUPLICATED_NICKNAME = "DN";  
    String DUPLICATED_PASSWORD = "DP";
    String DUPLICATED_CATEGORY = "DC";

    String SIGN_IN_FAILED = "SF";
    String NOT_EXIST_USER = "NU";
    String NOT_EXIST_BOARD = "NB";
    String PASS_FAILED =  "CPE";
    String NO_PERMISSION = "NP";
    String DATABASE_ERROR = "DBE";

}