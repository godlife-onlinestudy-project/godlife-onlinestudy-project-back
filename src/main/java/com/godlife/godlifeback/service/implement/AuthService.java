package com.godlife.godlifeback.service.implement;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.request.auth.SignInRequestDto;
import com.godlife.godlifeback.dto.response.auth.SignInResponseDto;

public interface AuthService {

    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
    
}
