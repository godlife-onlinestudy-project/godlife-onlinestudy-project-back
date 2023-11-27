package com.godlife.godlifeback.dto.response.study;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.entity.StudyEntity;

import lombok.Getter;

@Getter
public class GetModifyStudyResponseDto extends ResponseDto {
    private int studyNumber;
    private String studyName;
    private String studyEndDate;
    private int studyPersonal;
    private String studyCategory1;
    private boolean studyPublicCheck;
    private String studyPrivatePassword;
    private String studyCoverImageUrl;
    private String createStudyUserEmail;

    private GetModifyStudyResponseDto(String code, String message, StudyEntity studyEntity) {
        super(code, message);

        this.studyNumber = studyEntity.getStudyNumber();
        this.studyName = studyEntity.getStudyName();
        this.studyEndDate = studyEntity.getStudyEndDate();
        this.studyPersonal = studyEntity.getStudyPersonal();
        this.studyCategory1 = studyEntity.getStudyCategory1();
        this.studyPublicCheck = studyEntity.isStudyPublicCheck();
        this.studyPrivatePassword = studyEntity.getStudyPrivatePassword();
        this.studyCoverImageUrl = studyEntity.getStudyCoverImageUrl();
        this.createStudyUserEmail = studyEntity.getCreateStudyUserEmail();
    }

    public static ResponseEntity<GetModifyStudyResponseDto> success(StudyEntity studyEntity) {
        GetModifyStudyResponseDto result = new GetModifyStudyResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, studyEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistStudy() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_STUDY, ResponseMessage.NOT_EXIST_STUDY);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
