package com.godlife.godlifeback.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godlife.godlifeback.service.StudyService;
import com.godlife.godlifeback.dto.response.study.GetTop5StudyListResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/study")
@RequiredArgsConstructor
public class StudyController {

  private final StudyService studyService;

  @GetMapping("/top-5/{studyCategory1}")
  public ResponseEntity<? super GetTop5StudyListResponseDto> getTop5StudyList(
      @PathVariable("studyCategory1") String studyCategory1,
      @AuthenticationPrincipal String Email) {
    ResponseEntity<? super GetTop5StudyListResponseDto> response = studyService.getTop5StudyList(studyCategory1, Email);
    return response;
  }
}
