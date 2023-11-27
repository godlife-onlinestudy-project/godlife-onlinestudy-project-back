package com.godlife.godlifeback.dto.request.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchUserNicknameRequestDto {
    
    @NotBlank @Size(min=1, max=20)
    private String userNickname;

}
