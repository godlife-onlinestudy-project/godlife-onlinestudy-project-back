package com.godlife.godlifeback.dto.response;

public interface ResponseCode {

    String SUCCESS = "SU";

    String VALIDATION_FAILED = "VF";

    String DUPLICATED_EMAIL = "DE";
    String DUPLICATED_NICKNAME = "DN";
    String DUPLICATED_FAVORITE1 = "DF";
    
    String DUPLICATED_PASSWORD = "DP";
    String DUPLICATED_CATEGORY = "DC";

    String SIGN_IN_FAILED = "SF";
    String NOT_EXIST_USER = "NU";

    String NOT_EXIST_STUDY = "NS";
    String NOT_EXIST_STUDY_MATERIAL = "NM";
    String NO_PERMISSION = "NP";

    String PASS_FAILED =  "CPE";

    String DATABASE_ERROR = "DBE";
    String NOT_EXIST_USER_TO_DO_LIST = "NUTDL";
    String NOT_EXIST_BOARD = "NB";

    String EMAIL_NOT_FOUND = "ENF";
    String NOT_SAFE_PASSWORD = "NSP";
    String NOT_JOIN_USER = "NJ";
    String NOT_EXIST_USER_LIST = "NUL";
    String NOT_EXIST_STUDY_ROOM = "NS";
    String CANT_STUDY_DATE_MODIFY = "NC";

    String NOT_EXIST_NOTICE = "NN";
    String NOT_EXIST_TODOLIST = "SLN";
    String NOT_EXIST_MATERIAL = "SMCN";
}
