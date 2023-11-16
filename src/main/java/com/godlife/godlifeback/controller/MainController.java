package com.godlife.godlifeback.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godlife.godlifeback.dto.response.user.GetUserToDoListResponseDto;
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
    @AuthenticationPrincipal String userEmail
  ) {
    ResponseEntity<? super GetUserToDoListResponseDto> response = userService.getUserToDoList(userEmail, userListDatetime);
    return response;
  }
  
}
