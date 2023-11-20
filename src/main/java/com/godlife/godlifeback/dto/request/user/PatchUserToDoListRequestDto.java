package com.godlife.godlifeback.dto.request.user;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchUserToDoListRequestDto {

  @NotNull
  private Integer userListCheck;
  
}
