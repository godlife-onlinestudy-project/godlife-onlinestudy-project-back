package com.godlife.godlifeback.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="user_todolist")
@Table(name="user_todolist")
public class UserToDoListEntity {
  @Id
  private int userListNumber;
  private String userEmail;
  private String userListDatetime;
  private String userListContent;
  private int userListCheck;
}
