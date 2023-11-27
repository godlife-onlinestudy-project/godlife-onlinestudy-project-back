package com.godlife.godlifeback.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.godlife.godlifeback.dto.request.auth.SignUpRequestDto;
import com.godlife.godlifeback.dto.request.user.PatchUserFavorite1RequestDto;
import com.godlife.godlifeback.dto.request.user.PatchUserFavorite2RequestDto;
import com.godlife.godlifeback.dto.request.user.PatchUserFavorite3RequestDto;
import com.godlife.godlifeback.dto.request.user.PatchUserNicknameRequestDto;
import com.godlife.godlifeback.dto.request.user.PatchUserPasswordRequestDto;
import com.godlife.godlifeback.dto.request.user.PatchUserProfileImageUrlRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
@Entity(name="user")
public class UserEntity {
    
    @Id    
    private String userEmail;
    private String userPassword;
    private String userNickname;
    private String userFavorite1;
    private String userFavorite2;
    private String userFavorite3;
    private String userProfileImageUrl;
    private Integer userExperience;

    public UserEntity(SignUpRequestDto dto) {
        this.userEmail = dto.getUserEmail();
        this.userPassword = dto.getUserPassword();
        this.userNickname = dto.getUserNickname();
        this.userFavorite1 = dto.getUserFavorite1();
        this.userExperience = 0;
    }

    public UserEntity(String userEmail, String userNickname) {
        this.userEmail = userEmail;
        this.userNickname = userNickname;
        
    }

    public void patchUserNickname(PatchUserNicknameRequestDto dto) {
        this.userNickname = dto.getUserNickname();
    }

    public void patchUserPassword(PatchUserPasswordRequestDto dto) {
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
        this.userProfileImageUrl = dto.getUserProfileImageUrl();
    }


}
