package com.godlife.godlifeback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.godlife.godlifeback.dto.request.user.PatchUserToDoListRequestDto;
import com.godlife.godlifeback.dto.request.user.PostUserToDoListRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_todolist")
@Table(name = "user_todolist")
public class UserToDoListEntity {

  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int userListNumber;
  private String userEmail;
  private String userListDatetime;
  private String userListContent;
  private int userListCheck;
  
  public UserToDoListEntity(PostUserToDoListRequestDto dto, String userEmail) {
    this.userEmail = userEmail;
    this.userListDatetime = dto.getUserListDatetime();
    this.userListContent = dto.getUserListContent();
  }

  public void patch(PatchUserToDoListRequestDto dto) {
    this.userListCheck = dto.getUserListCheck();
  }
}
