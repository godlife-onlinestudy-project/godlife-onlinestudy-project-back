package com.godlife.godlifeback.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;

public class SendAuthenticateCodeResponseDto extends ResponseDto{

       private SendAuthenticateCodeResponseDto(String code, String message) {
        super(code, message);
    }

    public static ResponseEntity<SendAuthenticateCodeResponseDto> success() {
        SendAuthenticateCodeResponseDto result = new SendAuthenticateCodeResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    
}
