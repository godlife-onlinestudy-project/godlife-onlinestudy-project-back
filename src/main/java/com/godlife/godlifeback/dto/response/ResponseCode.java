package com.godlife.godlifeback.dto.response;

public interface ResponseCode {
    
    String SUCCESS = "SU";

    String VALIDATION_FAILED = "VF";

    String DUPLICATED_EMAIL = "DE";
    String DUPLICATED_NICKNAME = "DN";  
    String DUPLICATED_PASSWORD = "DP";
    String DUPLICATED_CATEGORY = "DC";

    String SIGN_IN_FAILED = "SF";
    String NOT_EXIST_USER = "NU";
    String PASS_FAILED =  "CPE";

    String DATABASE_ERROR = "DBE";

}
