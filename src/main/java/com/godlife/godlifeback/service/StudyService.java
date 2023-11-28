package com.godlife.godlifeback.service;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.study.GetTop5StudyListResponseDto;
import com.godlife.godlifeback.dto.response.study.GetSearchWordStudyListResponseDto;
import com.godlife.godlifeback.dto.response.study.GetSearchStudyListResponseDto;

public interface StudyService {
  ResponseEntity<? super GetTop5StudyListResponseDto> getTop5StudyList(String studyCategory1, String Email);

  ResponseEntity<? super GetSearchStudyListResponseDto> getSearchStudyList(String Email);

  ResponseEntity<? super GetSearchWordStudyListResponseDto> getSearchWordStudyList(String studyName, String Email);
}
