package com.godlife.godlifeback.dto.request.auth;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequestDto {

    @NotBlank @Email @Pattern(regexp = "/^[a-zA-Z0-9_]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$/")
    private String userEmail;

    @NotBlank @Size(min=8, max=20) @Pattern(regexp= "/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_?]).{8,15}$/")
    private String userPassword;

    @NotBlank @Size(min=1, max=20)
    private String userNickname;

    @NotBlank
    private String userFavorite1;
    
    private String userFavorite2;
    
    private String userFavorite3;

}