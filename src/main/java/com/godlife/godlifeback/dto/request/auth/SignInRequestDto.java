package com.godlife.godlifeback.dto.request.auth;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignInRequestDto {
    
    @NotBlank@Pattern(regexp = "/^[a-zA-Z0-9_]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$/")
    private String userEmail;
    
    @NotBlank
    private String userPassword;
}