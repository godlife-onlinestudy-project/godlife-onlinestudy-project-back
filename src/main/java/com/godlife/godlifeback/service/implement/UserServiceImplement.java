package com.godlife.godlifeback.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.user.GetUserToDoListResponseDto;
import com.godlife.godlifeback.entity.UserToDoListEntity;
import com.godlife.godlifeback.repository.UserToDoListRepository;
import com.godlife.godlifeback.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {
  
  private final UserToDoListRepository userToDoListRepository;

  @Override
  public ResponseEntity<? super GetUserToDoListResponseDto> getUserToDoList(String email, String userListDatetime) {

    List<UserToDoListEntity> userToDoListEntities = new ArrayList<>();

    try {

      userToDoListEntities = userToDoListRepository.findByEmailContainsAndUserListDatetimeContainsOrderByUserListNumber(email, userListDatetime);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetUserToDoListResponseDto.success(userToDoListEntities);

  }
  
}
