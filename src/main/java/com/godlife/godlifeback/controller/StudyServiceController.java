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

import com.godlife.godlifeback.dto.request.studyService.PatchStudyNoticeRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PatchStudyTodoListRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PostStudyNoticeRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PostStudyToDoListRequestDto;
import com.godlife.godlifeback.dto.response.studyService.DeleteStudyNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.DeleteStudyTodoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.GetStudyNoticeListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.GetStudyResponseDto;
import com.godlife.godlifeback.dto.response.studyService.GetStudyTodoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PatchStudyNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PatchStudyTodoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PostStudyNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PostStudyTodoListResponseDto;
import com.godlife.godlifeback.service.StudyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/service")
@RequiredArgsConstructor
public class StudyServiceController {
 
    private final StudyService studyService;

    @GetMapping("/{studyNumber}")
    ResponseEntity<? super GetStudyResponseDto> getStudy(
        @AuthenticationPrincipal String userEmail,
        @PathVariable("studyNumber")  Integer studyNumber
    ){
        ResponseEntity<? super GetStudyResponseDto> response = studyService.getStudy(userEmail, studyNumber);
        return response;
    }     

    @GetMapping("/{studyNumber}/notice")
    public ResponseEntity<? super GetStudyNoticeListResponseDto> getNotice(
        @AuthenticationPrincipal String userEmail,
        @PathVariable("studyNumber")  Integer studyNumber
    ){
        ResponseEntity<? super  GetStudyNoticeListResponseDto> response = studyService.getNotice(userEmail,studyNumber);
        return response;
    }    

    @PostMapping("/{studyNumber}/notice")
    public ResponseEntity<? super PostStudyNoticeResponseDto> postNotice(
        @RequestBody @Valid  PostStudyNoticeRequestDto  requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber
    ){
        ResponseEntity<? super PostStudyNoticeResponseDto> response = studyService.postNotice(requestBody, createStudyUserEmail,studyNumber);
        return response;
    }

    
    @PatchMapping("/{studyNumber}/notice/{studyNoticeNumber}")
    public ResponseEntity<? super PatchStudyNoticeResponseDto> patchNotice(
        @RequestBody @Valid  PatchStudyNoticeRequestDto  requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber,
        @PathVariable("studyNoticeNumber") Integer studyNoticeNumber        
    ){
        ResponseEntity<? super PatchStudyNoticeResponseDto> response = studyService.patchNotice(requestBody ,createStudyUserEmail,studyNumber,studyNoticeNumber);
        return response;
    }
    
    @DeleteMapping("/{studyNumber}/notice/{studyNoticeNumber}")
    public ResponseEntity<? super DeleteStudyNoticeResponseDto> deletNotice(
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber,
        @PathVariable("studyNoticeNumber") Integer studyNoticeNumber 
    ){
        ResponseEntity<? super DeleteStudyNoticeResponseDto> response = studyService.deleteNotice(createStudyUserEmail,studyNumber, studyNoticeNumber);
        return response;                
    }    
    
    @GetMapping("/{studyNumber}/todo-list")
    public ResponseEntity<? super GetStudyTodoListResponseDto> getTodolist(
        @AuthenticationPrincipal String userEmail,
        @PathVariable("studyNumber")  Integer studyNumber
    ){
        ResponseEntity<? super  GetStudyTodoListResponseDto> response = studyService.getTodolist(userEmail, studyNumber);
        return response;
    }        

    @PostMapping("/{studyNumber}/todo-list")
    public ResponseEntity<? super PostStudyTodoListResponseDto> postTodo(
        @RequestBody @Valid  PostStudyToDoListRequestDto requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber")  Integer studyNumber
    ){
        ResponseEntity<? super  PostStudyTodoListResponseDto> response = studyService.postTodo(requestBody, createStudyUserEmail, studyNumber);
        return response;
    }     
    
    @PatchMapping("/{studyNumber}/todo-list/{studyListNumber}")
    public ResponseEntity<? super PatchStudyTodoListResponseDto> postTodo(
        @RequestBody @Valid  PatchStudyTodoListRequestDto requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber")  Integer studyNumber,
        @PathVariable("studyListNumber")  Integer studyListNumber
    ){
        ResponseEntity<? super  PatchStudyTodoListResponseDto> response = studyService.patchTodo(requestBody, createStudyUserEmail, studyNumber, studyListNumber);
        return response;
    }          

    @DeleteMapping("/{studyNumber}/todo-list/{studyListNumber}")
    public ResponseEntity<? super DeleteStudyTodoListResponseDto> postTodo(
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber")  Integer studyNumber,
        @PathVariable("studyListNumber")  Integer studyListNumber
    ){
        ResponseEntity<? super  DeleteStudyTodoListResponseDto> response = studyService.deleteTodo( createStudyUserEmail, studyNumber, studyListNumber);
        return response;
    }    

}
