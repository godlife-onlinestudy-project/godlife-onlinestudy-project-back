package com.godlife.godlifeback.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
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

import com.godlife.godlifeback.dto.request.user.PatchUserToDoListRequestDto;
import com.godlife.godlifeback.dto.response.user.GetUserToDoListResponseDto;
import com.godlife.godlifeback.dto.response.user.PatchUserToDoListResponseDto;
import com.godlife.godlifeback.dto.request.user.PostUserToDoListRequestDto;
import com.godlife.godlifeback.dto.response.user.PostUserToDoListResponseDto;
import com.godlife.godlifeback.dto.response.user.DeleteUserToDoListResponseDto;
import com.godlife.godlifeback.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {

  private final UserService userService;

  @GetMapping("/main/user-todolist/{userListDatetime}")
  public ResponseEntity<? super GetUserToDoListResponseDto> getUserToDoList(
      @PathVariable("userListDatetime") String userListDatetime,
      @AuthenticationPrincipal String userEmail) {
    ResponseEntity<? super GetUserToDoListResponseDto> response = userService.getUserToDoList(userEmail,
        userListDatetime);
    return response;
  }

  @PatchMapping("/main/user-todolist/{userListDatetime}/{userListNumber}")
  public ResponseEntity<? super PatchUserToDoListResponseDto> patchUserToDoList(
      @RequestBody @Valid PatchUserToDoListRequestDto requestBody,
      @PathVariable("userListDatetime") String userListDatetime,
      @PathVariable("userListNumber") Integer userListNumber,
      @AuthenticationPrincipal String userEmail) {
    ResponseEntity<? super PatchUserToDoListResponseDto> response = userService.patchUserToDoList(requestBody,
        userListNumber, userEmail, userListDatetime);
    return response;
  }

  @PostMapping("/main/user-todolist/post")
  public ResponseEntity<? super PostUserToDoListResponseDto> postUserToDoList(
      @RequestBody @Valid PostUserToDoListRequestDto requestBody,
      @AuthenticationPrincipal String userEmail) {
    ResponseEntity<? super PostUserToDoListResponseDto> response = userService.postUserToDoList(requestBody, userEmail);
    return response;
  }

  @DeleteMapping("/main/user-todolist/{userListNumber}")
  public ResponseEntity<? super DeleteUserToDoListResponseDto> deleteUserToDoList(
      @PathVariable("userListNumber") List<Integer> userListNumber,
      @AuthenticationPrincipal String userEmail) {
    ResponseEntity<? super DeleteUserToDoListResponseDto> response = userService.deleteUserToDoList(userListNumber,
        userEmail);
    return response;
  }

}
