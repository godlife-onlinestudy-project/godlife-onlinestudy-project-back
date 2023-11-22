package com.godlife.godlifeback.dto.response.studyServie;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.entity.StudyNoticeListEntity;

import lombok.Getter;

@Getter
public class PostNoticeListResponseDto extends ResponseDto{
    private int studyNoticeNumber;
    private int studyNumber;
    private String noticeContent;

    private PostNoticeListResponseDto(String code, String message, StudyNoticeListEntity studyNoticeEntity ){
        super(code, message);

        this.studyNoticeNumber = studyNoticeEntity.getStudyNoticeNumber();
        this.studyNumber = studyNoticeEntity.getStudyNumber();
        
    }

    public static ResponseEntity<PostNoticeListResponseDto> success(StudyNoticeListEntity studyNoticeEntity){
        PostNoticeListResponseDto  result = new PostNoticeListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, studyNoticeEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistNotice(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_NOTICE_EXISTS, ResponseMessage.NOT_NOTICE_EXISTS);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

}
