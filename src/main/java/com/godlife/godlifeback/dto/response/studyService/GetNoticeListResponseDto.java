package com.godlife.godlifeback.dto.response.studyService;

import com.godlife.godlifeback.common.object.StudyNoticeListItem;
import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.repository.resultSet.StudyNoticeListResultSet;

import lombok.Getter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@Getter
public class GetNoticeListResponseDto  extends ResponseDto{
    
    private List<StudyNoticeListItem> noticeList; 

    private  GetNoticeListResponseDto(String code , String message, List<StudyNoticeListResultSet> resultSets){
        super(code, message);
        this.noticeList = StudyNoticeListItem.getNoticeList(resultSets);
    }

    public static ResponseEntity<GetNoticeListResponseDto> success( List<StudyNoticeListResultSet> resultSets){
        GetNoticeListResponseDto result = new GetNoticeListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistNotice(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_NOTICE_EXISTS, ResponseMessage.NOT_NOTICE_EXISTS);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }    

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    
    public static ResponseEntity<ResponseDto> notExistStudy(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_STUDY, ResponseMessage.NOT_EXIST_STUDY);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    
    public static ResponseEntity<ResponseDto> noPermission(){
        ResponseDto result = new ResponseDto(ResponseCode.NO_PERMISSION, ResponseMessage.NO_PERMISSION);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }    
}
