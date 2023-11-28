package com.godlife.godlifeback.service;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.request.auth.AuthenticateCodeCheckRequestDto;
import com.godlife.godlifeback.dto.request.auth.SendAuthenticateCodeRequestDto;
import com.godlife.godlifeback.dto.request.auth.SignInEmailCheckRequestDto;
import com.godlife.godlifeback.dto.request.auth.SignInRequestDto;
import com.godlife.godlifeback.dto.request.auth.SignUpRequestDto;
import com.godlife.godlifeback.dto.response.auth.AuthenticateCodeCheckResponseDto;
import com.godlife.godlifeback.dto.response.auth.SendAuthenticateCodeResponseDto;
import com.godlife.godlifeback.dto.response.auth.SignInEmailcheckResponseDto;
import com.godlife.godlifeback.dto.response.auth.SignInResponseDto;
import com.godlife.godlifeback.dto.response.auth.SignUpResponseDto;

public interface AuthService {

    ResponseEntity<? super SignInEmailcheckResponseDto> signInEmailCheck(SignInEmailCheckRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);

    ResponseEntity<? super SendAuthenticateCodeResponseDto> sendAuthenticateCode(SendAuthenticateCodeRequestDto dto);

    ResponseEntity<? super AuthenticateCodeCheckResponseDto> authenticateCodeCheck(AuthenticateCodeCheckRequestDto dto);
    
}
