package com.godlife.godlifeback.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godlife.godlifeback.dto.request.study.PatchStudyRequestDto;
import com.godlife.godlifeback.dto.request.study.PostStudyRequestDto;
import com.godlife.godlifeback.dto.response.study.GetModifyStudyResponseDto;
import com.godlife.godlifeback.dto.response.study.PatchStudyResponseDto;
import com.godlife.godlifeback.dto.response.study.PostStudyResponseDto;
import com.godlife.godlifeback.service.StudyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/main/home")
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;

    @GetMapping("/{studyNumber}")
    public ResponseEntity<? super GetModifyStudyResponseDto> getModifyStudy(
        @PathVariable("studyNumber") Integer studyNumber,
        @AuthenticationPrincipal String userEmail
    ) {
        ResponseEntity<? super GetModifyStudyResponseDto> response = studyService.getModifyStudy(studyNumber, userEmail);
        return response;
    }
    
    @PostMapping("")
    public ResponseEntity<? super PostStudyResponseDto> postStudy(
        @RequestBody @Valid PostStudyRequestDto requestBody,
        @AuthenticationPrincipal String userEmail
    ) {
        ResponseEntity<? super PostStudyResponseDto> response = studyService.postStudy(requestBody, userEmail);
        return response;
    }

    @PatchMapping("/{studyNumber}")
    public ResponseEntity<? super PatchStudyResponseDto> patchStudy(
        @RequestBody @Valid PatchStudyRequestDto requestBody,
        @PathVariable("studyNumber") Integer studyNumber,
        @AuthenticationPrincipal String userEmail
    ) {
        ResponseEntity<? super PatchStudyResponseDto> response = studyService.patchStudy(requestBody, studyNumber, userEmail);
        return response;
    }

}