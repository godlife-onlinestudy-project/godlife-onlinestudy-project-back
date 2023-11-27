package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.entity.UserToDoListEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserToDoListItem {
  private int userListNumber;
  private String userEmail;
  private String userListDatetime;
  private String userListContent;
  private int userListCheck;

  public UserToDoListItem(UserToDoListEntity userToDoListEntity) {
    this.userListNumber = userToDoListEntity.getUserListNumber();
    this.userEmail = userToDoListEntity.getUserEmail();
    this.userListDatetime = userToDoListEntity.getUserListDatetime();
    this.userListContent = userToDoListEntity.getUserListContent();
    this.userListCheck = userToDoListEntity.getUserListCheck();
  }

  public static List<UserToDoListItem> getList(List<UserToDoListEntity> userToDoListEntities) {
    List<UserToDoListItem> list = new ArrayList<>();
    for (UserToDoListEntity userToDoListEntity: userToDoListEntities) {
      UserToDoListItem userToDoListItem = new UserToDoListItem(userToDoListEntity);
      list.add(userToDoListItem);
    }
    return list;
  }
}