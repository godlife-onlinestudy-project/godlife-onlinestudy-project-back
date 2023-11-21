package com.godlife.godlifeback.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.godlife.godlifeback.dto.request.user.PatchUserToDoListRequestDto;
import com.godlife.godlifeback.dto.request.user.PostUserToDoListRequestDto;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.user.GetUserToDoListResponseDto;
import com.godlife.godlifeback.dto.response.user.PatchUserToDoListResponseDto;
import com.godlife.godlifeback.dto.response.user.PostUserToDoListResponseDto;
import com.godlife.godlifeback.entity.UserToDoListEntity;
import com.godlife.godlifeback.repository.UserToDoListRepository;
import com.godlife.godlifeback.repository.UserToDoListViewRepository;
import com.godlife.godlifeback.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {
  
  private final UserToDoListViewRepository userToDoListViewRepository;
  private final UserToDoListRepository userToDoListRepository;

  @Override
  public ResponseEntity<? super GetUserToDoListResponseDto> getUserToDoList(String userEmail, String userListDatetime) {

    List<UserToDoListEntity> userToDoListEntities = new ArrayList<>();

    try {

      userToDoListEntities = userToDoListViewRepository.findByUserEmailContainsAndUserListDatetimeContainsOrderByUserListNumber(userEmail, userListDatetime);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetUserToDoListResponseDto.success(userToDoListEntities);
  }
  
  @Override
  public ResponseEntity<? super PatchUserToDoListResponseDto> patchUserToDoList(PatchUserToDoListRequestDto dto, Integer userListNumber, String userEmail, String userListDatetime) {
    
    try {

      boolean existedUser = userToDoListRepository.existsByUserEmail(userEmail);
      if (!existedUser) return PatchUserToDoListResponseDto.notExistUser();

      UserToDoListEntity userToDoListEntity = userToDoListRepository.findByUserListNumber(userListNumber);
      if (userToDoListEntity == null) return PatchUserToDoListResponseDto.notExistUserToDoList();

      userToDoListEntity.patch(dto);
      userToDoListRepository.save(userToDoListEntity);

    } catch(Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return PatchUserToDoListResponseDto.success();

  }

  @Override
  public ResponseEntity<? super PostUserToDoListResponseDto> postUserToDoList(PostUserToDoListRequestDto dto, String userEmail) {
    try {

      boolean existedUser = userToDoListRepository.existsByUserEmail(userEmail);
      if (!existedUser) return PostUserToDoListResponseDto.notExistUser();

      UserToDoListEntity userToDoListEntity = new UserToDoListEntity(dto, userEmail);
      userToDoListRepository.save(userToDoListEntity);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return PostUserToDoListResponseDto.success();

  }

}
