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

import com.godlife.godlifeback.dto.request.studyService.PostNoticeRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PatchNoticeRequestDto;

import com.godlife.godlifeback.dto.response.studyService.GetNoticeListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PatchNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.DeleteNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PostNoticeResponseDto;


import com.godlife.godlifeback.dto.request.studyService.PatchToDoListRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PostToDoListRequestDto;

import com.godlife.godlifeback.dto.response.studyService.GetToDoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PostToDoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PatchToDoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.DeleteToDoListResponseDto;

public interface StudyService {
    
    ResponseEntity<? super GetModifyStudyResponseDto> getModifyStudy(Integer studyNumber, String userEmail);

    ResponseEntity<? super GetStudyUserListResponseDto> getStudyUserList(Integer studyNumber, String userEmail);

    ResponseEntity<? super PostStudyResponseDto> postStudy(PostStudyRequestDto dto, String userEmail);

    ResponseEntity<? super PatchStudyResponseDto> patchStudy(PatchStudyRequestDto dto, Integer studyNumber, String userEmail);

    ResponseEntity<? super DeleteStudyUserListResponseDto> deleteStudyUserList(Integer studyNumber, String userEmail, String createStudyUserEmail);

    ResponseEntity<? super GetTop5StudyListResponseDto> getTop5StudyList(String studyCategory1, String Email);

    ResponseEntity<? super GetNoticeListResponseDto> getNotice(String userEmail,Integer studyNumber);

    ResponseEntity<? super PostNoticeResponseDto> postNotice(PostNoticeRequestDto dto,String createStudyUserEmail, Integer studyNumber);

    ResponseEntity<? super PatchNoticeResponseDto> patchNotice(PatchNoticeRequestDto dto ,String createStudyUserEmail, Integer studyNumber,Integer studyNoticeNumber);    

    ResponseEntity<? super DeleteNoticeResponseDto> deleteNotice(String createStudyUserEmail,Integer studyNumber,Integer studyNoticeNumber);       

    
    ResponseEntity<? super GetToDoListResponseDto> getTodolist(String userEmail,Integer studyNumber);
    ResponseEntity<? super PostToDoListResponseDto > postTodo(PostToDoListRequestDto dto,String createStudyUserEmail, Integer studyNumber);
    ResponseEntity<? super PatchToDoListResponseDto> patchTodo(PatchToDoListRequestDto requestBody, String createStudyUserEmail,Integer studyNumber,Integer studyListNumber);
    ResponseEntity<? super DeleteToDoListResponseDto> deleteTodo(String createStudyUserEmail,Integer studyNumber,Integer studyListNumber);
}
