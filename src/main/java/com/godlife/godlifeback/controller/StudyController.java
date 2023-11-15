package com.godlife.godlifeback.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godlife.godlifeback.dto.request.study.PostStudyRequestDto;
import com.godlife.godlifeback.dto.response.study.PostStudyResponseDto;
import com.godlife.godlifeback.service.StudyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/main/home")
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;
    
    @PostMapping("")
    public ResponseEntity<? super PostStudyResponseDto> postStudy(
        @RequestBody @Valid PostStudyRequestDto requestBody,
        @AuthenticationPrincipal String userEmail
    ) {
        ResponseEntity<? super PostStudyResponseDto> response = studyService.postStudy(requestBody, userEmail);
        return response;
    }
}
