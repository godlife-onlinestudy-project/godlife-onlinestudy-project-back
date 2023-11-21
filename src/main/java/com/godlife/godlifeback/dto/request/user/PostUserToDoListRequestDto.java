package com.godlife.godlifeback.dto.request.user;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostUserToDoListRequestDto {
  
  @NotNull
  private String userListDatetime;

  @NotNull
  private String userListContent;

}
