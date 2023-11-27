package com.godlife.godlifeback.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;

public class AuthenticateCodeCheckResponseDto extends ResponseDto{

        private AuthenticateCodeCheckResponseDto(String code, String message) {
        super(code, message);
    }

    public static ResponseEntity<AuthenticateCodeCheckResponseDto> success() {
        AuthenticateCodeCheckResponseDto result = new AuthenticateCodeCheckResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
        }

    public static ResponseEntity<ResponseDto> notExistCode() {
        ResponseDto result = new ResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
