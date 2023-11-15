package com.godlife.godlifeback.service;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.request.study.PostStudyRequestDto;
import com.godlife.godlifeback.dto.response.study.PostStudyResponseDto;

public interface StudyService {
    
    ResponseEntity<? super PostStudyResponseDto> postStudy(PostStudyRequestDto dto, String userEmail);

}
