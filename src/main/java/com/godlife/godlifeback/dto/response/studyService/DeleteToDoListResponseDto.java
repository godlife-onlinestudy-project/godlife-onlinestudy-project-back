package com.godlife.godlifeback.dto.response.studyService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;

public class DeleteToDoListResponseDto extends ResponseDto{
    
    private DeleteToDoListResponseDto(String code, String message){
        super(code, message);
    }

    public static ResponseEntity<DeleteToDoListResponseDto> success(){
        DeleteToDoListResponseDto result =  new DeleteToDoListResponseDto(ResponseCode.SUCCESS,  ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
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

    public static ResponseEntity<ResponseDto> notExistToDoList(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_TODOLIST_EXISTS, ResponseMessage.NOT_TODOLIST_EXISTS);
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);    
    }
}
