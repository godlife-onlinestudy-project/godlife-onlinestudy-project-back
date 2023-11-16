package com.godlife.godlifeback.service;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.user.GetUserToDoListResponseDto;

public interface UserService {
  
  ResponseEntity<? super GetUserToDoListResponseDto> getUserToDoList(String email, String userListDatetime);

}
