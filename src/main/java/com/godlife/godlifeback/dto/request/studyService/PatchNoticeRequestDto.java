package com.godlife.godlifeback.dto.request.studyService;


import javax.validation.constraints.NotBlank;

import com.godlife.godlifeback.dto.response.ResponseDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NotBlank 
@Setter
@NoArgsConstructor
@Getter
public class PatchNoticeRequestDto extends ResponseDto{
    
    @NotBlank
    private String noticeContent;


}