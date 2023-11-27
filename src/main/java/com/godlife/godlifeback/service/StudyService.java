package com.godlife.godlifeback.service;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.request.study.PatchStudyRequestDto;
import com.godlife.godlifeback.dto.request.study.PostStudyRequestDto;
import com.godlife.godlifeback.dto.response.study.DeleteStudyUserListResponseDto;
import com.godlife.godlifeback.dto.response.study.GetModifyStudyResponseDto;
import com.godlife.godlifeback.dto.response.study.GetStudyUserListResponseDto;
import com.godlife.godlifeback.dto.response.study.PatchStudyResponseDto;
import com.godlife.godlifeback.dto.response.study.PostStudyResponseDto;
import com.godlife.godlifeback.dto.response.study.GetTop5StudyListResponseDto;

public interface StudyService {
    
    ResponseEntity<? super GetModifyStudyResponseDto> getModifyStudy(Integer studyNumber, String userEmail);

    ResponseEntity<? super GetStudyUserListResponseDto> getStudyUserList(Integer studyNumber, String userEmail);

    ResponseEntity<? super PostStudyResponseDto> postStudy(PostStudyRequestDto dto, String userEmail);

    ResponseEntity<? super PatchStudyResponseDto> patchStudy(PatchStudyRequestDto dto, Integer studyNumber, String userEmail);

    ResponseEntity<? super DeleteStudyUserListResponseDto> deleteStudyUserList(Integer studyNumber, String userEmail, String createStudyUserEmail);

    ResponseEntity<? super GetTop5StudyListResponseDto> getTop5StudyList(String studyCategory1, String Email);

}
