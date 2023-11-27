package com.godlife.godlifeback.dto.request.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticateCodeCheckRequestDto {
    private String UserEmail;
    private int code;
}
