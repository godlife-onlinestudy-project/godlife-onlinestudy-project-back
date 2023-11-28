package com.godlife.godlifeback.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godlife.godlifeback.dto.request.studyService.PatchNoticeRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PatchToDoListRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PostNoticeRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PostToDoListRequestDto;
import com.godlife.godlifeback.dto.response.studyService.DeleteNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.DeleteToDoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.GetNoticeListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.GetToDoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PatchNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PatchToDoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PostNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PostToDoListResponseDto;
import com.godlife.godlifeback.service.StudyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/service")
@RequiredArgsConstructor
public class StudyServiceController {
 
    private final StudyService studyService;

    @GetMapping("/{studyNumber}/notice")
    public ResponseEntity<? super GetNoticeListResponseDto> getNotice(
        @AuthenticationPrincipal String userEmail,
        @PathVariable("studyNumber")  Integer studyNumber
    ){
        ResponseEntity<? super  GetNoticeListResponseDto> response = studyService.getNotice(userEmail,studyNumber);
        return response;
    }    

    @PostMapping("/{studyNumber}/notice")
    public ResponseEntity<? super PostNoticeResponseDto> postNotice(
        @RequestBody @Valid  PostNoticeRequestDto  requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber
    ){
        ResponseEntity<? super PostNoticeResponseDto> response = studyService.postNotice(requestBody, createStudyUserEmail,studyNumber);
        return response;
    }

    
    @PatchMapping("/{studyNumber}/notice/{studyNoticeNumber}")
    public ResponseEntity<? super PatchNoticeResponseDto> patchNotice(
        @RequestBody @Valid  PatchNoticeRequestDto  requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber,
        @PathVariable("studyNoticeNumber") Integer studyNoticeNumber        
    ){
        ResponseEntity<? super PatchNoticeResponseDto> response = studyService.patchNotice(requestBody ,createStudyUserEmail,studyNumber,studyNoticeNumber);
        return response;
    }
    
    @DeleteMapping("/{studyNumber}/notice/{studyNoticeNumber}")
    public ResponseEntity<? super DeleteNoticeResponseDto> deletNotice(
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber,
        @PathVariable("studyNoticeNumber") Integer studyNoticeNumber 
    ){
        ResponseEntity<? super DeleteNoticeResponseDto> response = studyService.deleteNotice(createStudyUserEmail,studyNumber, studyNoticeNumber);
        return response;                
    }    
    
    @GetMapping("/{studyNumber}/todo-list")
    public ResponseEntity<? super GetToDoListResponseDto> getTodolist(
        @AuthenticationPrincipal String userEmail,
        @PathVariable("studyNumber")  Integer studyNumber
    ){
        ResponseEntity<? super  GetToDoListResponseDto> response = studyService.getTodolist(userEmail, studyNumber);
        return response;
    }        

    @PostMapping("/{studyNumber}/todo-list")
    public ResponseEntity<? super PostToDoListResponseDto> postTodo(
        @RequestBody @Valid  PostToDoListRequestDto requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber")  Integer studyNumber
    ){
        ResponseEntity<? super  PostToDoListResponseDto> response = studyService.postTodo(requestBody, createStudyUserEmail, studyNumber);
        return response;
    }     
    
    @PatchMapping("/{studyNumber}/todo-list")
    public ResponseEntity<? super PatchToDoListResponseDto> postTodo(
        @RequestBody @Valid  PatchToDoListRequestDto requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber")  Integer studyNumber,
        @PathVariable("studyListNumber")  Integer studyListNumber
    ){
        ResponseEntity<? super  PatchToDoListResponseDto> response = studyService.patchTodo(requestBody, createStudyUserEmail, studyNumber, studyListNumber);
        return response;
    }          

    @DeleteMapping("/{studyNumber}/todo-list")
    public ResponseEntity<? super DeleteToDoListResponseDto> postTodo(
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber")  Integer studyNumber,
        @PathVariable("studyListNumber")  Integer studyListNumber
    ){
        ResponseEntity<? super  DeleteToDoListResponseDto> response = studyService.deleteTodo( createStudyUserEmail, studyNumber, studyListNumber);
        return response;
    }    

}
