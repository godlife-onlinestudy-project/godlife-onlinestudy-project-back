package com.godlife.godlifeback.dto.response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class DeleteUserToDoListResponseDto extends ResponseDto {
  
  private DeleteUserToDoListResponseDto(String code, String message) {
    super(code, message);
  }

  public static ResponseEntity<DeleteUserToDoListResponseDto> success() {
    DeleteUserToDoListResponseDto result = new DeleteUserToDoListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> notExistUser() {
    ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  public static ResponseEntity<ResponseDto> notExistUserToDoList() {
    ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER_TO_DO_LIST, ResponseMessage.NOT_EXIST_USER_TO_DO_LIST);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
}
