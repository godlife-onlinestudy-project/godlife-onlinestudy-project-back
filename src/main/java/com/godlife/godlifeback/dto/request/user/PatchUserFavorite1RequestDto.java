package com.godlife.godlifeback.dto.request.user;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class PatchUserFavorite1RequestDto {
    
    @NotBlank
    private String userFavorite1;
    
}
