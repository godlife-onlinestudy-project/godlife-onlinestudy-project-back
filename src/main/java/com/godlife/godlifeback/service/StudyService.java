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
import com.godlife.godlifeback.dto.response.study.GetSearchWordStudyListResponseDto;
import com.godlife.godlifeback.dto.response.study.GetSearchStudyListResponseDto;

import com.godlife.godlifeback.dto.request.studyService.PostStudyNoticeRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PatchStudyNoticeRequestDto;

import com.godlife.godlifeback.dto.response.studyService.GetStudyNoticeListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.GetStudyResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PatchStudyNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.DeleteStudyNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.DeleteStudyTodoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PostStudyNoticeResponseDto;


import com.godlife.godlifeback.dto.request.studyService.PatchStudyTodoListRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PostStudyToDoListRequestDto;

import com.godlife.godlifeback.dto.response.studyService.GetStudyTodoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PostStudyTodoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PatchStudyTodoListResponseDto;

public interface StudyService {

  ResponseEntity<? super GetSearchStudyListResponseDto> getSearchStudyList(String Email);

  ResponseEntity<? super GetSearchWordStudyListResponseDto> getSearchWordStudyList(String studyName, String Email);

  ResponseEntity<? super GetModifyStudyResponseDto> getModifyStudy(Integer studyNumber, String userEmail);

  ResponseEntity<? super GetStudyUserListResponseDto> getStudyUserList(Integer studyNumber, String userEmail);

  ResponseEntity<? super PostStudyResponseDto> postStudy(PostStudyRequestDto dto, String userEmail);

  ResponseEntity<? super PatchStudyResponseDto> patchStudy(PatchStudyRequestDto dto, Integer studyNumber,String userEmail);

  ResponseEntity<? super DeleteStudyUserListResponseDto> deleteStudyUserList(Integer studyNumber, String userEmail,String createStudyUserEmail);

  ResponseEntity<? super GetTop5StudyListResponseDto> getTop5StudyList(String studyCategory1, String Email);

    ResponseEntity<? super GetStudyResponseDto> getStudy(String userEmail, Integer studyNumber);

    ResponseEntity<? super GetStudyNoticeListResponseDto> getNotice(String userEmail,Integer studyNumber);
    ResponseEntity<? super PostStudyNoticeResponseDto> postNotice(PostStudyNoticeRequestDto dto,String createStudyUserEmail, Integer studyNumber);
    ResponseEntity<? super PatchStudyNoticeResponseDto> patchNotice(PatchStudyNoticeRequestDto dto ,String createStudyUserEmail, Integer studyNumber,Integer studyNoticeNumber);    
    ResponseEntity<? super DeleteStudyNoticeResponseDto> deleteNotice(String createStudyUserEmail,Integer studyNumber,Integer studyNoticeNumber);       

    
    ResponseEntity<? super GetStudyTodoListResponseDto> getTodolist(String userEmail,Integer studyNumber);
    ResponseEntity<? super PostStudyTodoListResponseDto> postTodo(PostStudyToDoListRequestDto dto,String createStudyUserEmail, Integer studyNumber);
    ResponseEntity<? super PatchStudyTodoListResponseDto> patchTodo(PatchStudyTodoListRequestDto requestBody, String createStudyUserEmail,Integer studyNumber,Integer studyListNumber);
    ResponseEntity<? super DeleteStudyTodoListResponseDto> deleteTodo(String createStudyUserEmail,Integer studyNumber,Integer studyListNumber);
}
