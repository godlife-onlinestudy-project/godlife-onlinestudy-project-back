package com.godlife.godlifeback.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.godlife.godlifeback.provider.MailProvider;
import com.godlife.godlifeback.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final MailProvider mailProvider;

    @PostMapping("/sign-in-email-check")
    public ResponseEntity<? super SignInEmailcheckResponseDto> signInEmailCheck(
        @RequestBody @Valid SignInEmailCheckRequestDto requestBody
    ) {
        ResponseEntity<? super SignInEmailcheckResponseDto> response = authService.signInEmailCheck(requestBody);
        return response;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<? super SignUpResponseDto> signUp(
        @RequestBody @Valid SignUpRequestDto requestBody
    ) {
        ResponseEntity<? super SignUpResponseDto> response = authService.signUp(requestBody);
        return response;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<? super SignInResponseDto> signIn(
        @RequestBody @Valid SignInRequestDto requestBody
    ) {
        ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }

    @PostMapping("/send-authenticate-code")
    public ResponseEntity<? super SendAuthenticateCodeResponseDto> sendAuthenticateCode(
        @RequestBody @Valid SendAuthenticateCodeRequestDto requestBody
    ) {
        ResponseEntity<? super SendAuthenticateCodeResponseDto> response = authService.sendAuthenticateCode(requestBody);
        return response;
    }

    @PostMapping("/send-authenticate-code-check")
    public ResponseEntity<? super AuthenticateCodeCheckResponseDto> authenticateCodecheck(
        @RequestBody @Valid AuthenticateCodeCheckRequestDto requestBody
    ) {
        ResponseEntity<? super AuthenticateCodeCheckResponseDto> response = authService.authenticateCodeCheck(requestBody);
        return response;
    }
    
}
