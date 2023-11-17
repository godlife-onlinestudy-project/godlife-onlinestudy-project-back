package com.godlife.godlifeback.dto.response;

public interface ResponseCode {

    String SUCCESS = "SU";

    String VALIDATION_FAILED = "VF";
    String DUPLICATED_EMAIL = "DE";
    String DUPLICATED_NICKNAME = "DN";
    
    String NOT_EXIST_USER = "NU";
    

    String SIGN_IN_FAILED = "SF";

    String NO_PERMISSION = "NP";

    String DATABASE_ERROR = "DBE";

}