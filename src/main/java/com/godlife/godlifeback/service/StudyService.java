package com.godlife.godlifeback.service;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.request.study.PatchStudyRequestDto;
import com.godlife.godlifeback.dto.request.study.PostStudyRequestDto;
import com.godlife.godlifeback.dto.response.study.GetModifyStudyResponseDto;
import com.godlife.godlifeback.dto.response.study.PatchStudyResponseDto;
import com.godlife.godlifeback.dto.response.study.PostStudyResponseDto;

public interface StudyService {
    
    ResponseEntity<? super GetModifyStudyResponseDto> getModifyStudy(Integer studyNumber, String userEmail);

    ResponseEntity<? super PostStudyResponseDto> postStudy(PostStudyRequestDto dto, String userEmail);

    ResponseEntity<? super PatchStudyResponseDto> patchStudy(PatchStudyRequestDto dto, Integer studyNumber, String userEmail);

}
