package com.godlife.godlifeback.dto.request.studyService;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchToDoListRequestDto {
    
    @NotBlank @Size(min = 1)
    private String studyListContent;


    @NotNull @AssertTrue
    private Boolean studyListCheck;
}
