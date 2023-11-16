package com.godlife.godlifeback.dto.request.study;

import javax.validation.constraints.NotBlank;

import com.godlife.godlifeback.dto.response.ResponseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchNoticeRequestDto extends ResponseDto{
    
    @NotBlank
    private String noticeContent;
}