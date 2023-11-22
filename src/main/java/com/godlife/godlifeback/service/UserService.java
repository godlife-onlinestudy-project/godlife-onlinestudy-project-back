package com.godlife.godlifeback.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.request.user.PatchUserToDoListRequestDto;
import com.godlife.godlifeback.dto.request.user.PostUserToDoListRequestDto;
import com.godlife.godlifeback.dto.response.user.GetUserToDoListResponseDto;
import com.godlife.godlifeback.dto.response.user.PatchUserToDoListResponseDto;
import com.godlife.godlifeback.dto.response.user.PostUserToDoListResponseDto;
import com.godlife.godlifeback.dto.response.user.DeleteUserToDoListResponseDto;

public interface UserService {

  ResponseEntity<? super GetUserToDoListResponseDto> getUserToDoList(String userEmail, String userListDatetime);

  ResponseEntity<? super PatchUserToDoListResponseDto> patchUserToDoList(PatchUserToDoListRequestDto dto,
      Integer userListNumber, String userEmail, String userListDatetime);

  ResponseEntity<? super PostUserToDoListResponseDto> postUserToDoList(PostUserToDoListRequestDto dto,
      String userEmail);

  ResponseEntity<? super DeleteUserToDoListResponseDto> deleteUserToDoList(List<Integer> userListNumber,
      String userEmail);

}
