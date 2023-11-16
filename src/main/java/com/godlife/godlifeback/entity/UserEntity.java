package com.godlife.godlifeback.entity;
import javax.persistence.Id;

import com.godlife.godlifeback.dto.request.auth.SignUpRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity {
    
    @Id    
    private String userEmail;
    private String userPassword;
    private String userNickname;
    private String userFavorite1;
    private String userFavorite2;
    private String userFavorite3;
    private String userProfileImageUrl;
    private String userExp;

    public UserEntity(SignUpRequestDto dto) {
        this.userEmail = dto.getUserEmail();
        this.userPassword = dto.getUserPassword();
        this.userNickname = dto.getUserNickname();
        this.userFavorite1 = dto.getUserFavorite1();
        this.userFavorite2 = dto.getUserFavorite2();
        this.userFavorite3 = dto.getUserFavorite3();
    }

    public void patchUserNickname(PatchUserNicknameRequestDto dto) {
        this.userNickname = dto.getUserNickname();
    }

    public void patchUserPassword(PatchUserNicknameRequestDto dto) {
        this.userPassword = dto.getUserPassword();
    }

    public void patchUserFavorite1(PatchUserFavorite1RequestDto dto) {
        this.userFavorite1 = dto.getUserFavorite1();
    }

    public void patchUserFavorite2(PatchUserFavorite2RequestDto dto) {
        this.userFavorite2 = dto.getUserFavorite2();
    }

    public void patchUserFavorite3(PatchUserFavorite3RequestDto dto) {
        this.userFavorite3 = dto.getUserFavorite3();
    }

    public void patchUserProfileImageUrl(PatchUserProfileImageUrlRequestDto dto) {
        this.userProfileImageUrl = dto.getUserNickname();
    }


}
