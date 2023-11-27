package com.godlife.godlifeback.dto.response.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.common.object.UserToDoListItem;
import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.entity.UserToDoListEntity;

import lombok.Getter;

@Getter
public class GetUserToDoListResponseDto extends ResponseDto {

  private List<UserToDoListItem> userToDoList;

  private GetUserToDoListResponseDto(String code, String message, List<UserToDoListEntity> userToDoListEntities) {
    super(code, message);
    this.userToDoList = UserToDoListItem.getList(userToDoListEntities);
  }

  public static ResponseEntity<GetUserToDoListResponseDto> success(List<UserToDoListEntity> userToDoListEntities) {
    GetUserToDoListResponseDto result = new GetUserToDoListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, userToDoListEntities);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

}