package com.godlife.godlifeback.service;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.study.GetTop5StudyListResponseDto;

public interface StudyService {
  ResponseEntity<? super GetTop5StudyListResponseDto> getTop5StudyList(String studyCategory1, String Email);
}
