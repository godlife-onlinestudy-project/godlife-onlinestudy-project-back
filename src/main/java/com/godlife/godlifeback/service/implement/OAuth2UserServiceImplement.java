package com.godlife.godlifeback.service.implement;

import java.util.Map;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.godlife.godlifeback.entity.ApplicationOAuth2User;
import com.godlife.godlifeback.entity.UserEntity;
import com.godlife.godlifeback.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OAuth2UserServiceImplement extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    
    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(request);

        try {
          System.out.println(new ObjectMapper().writeValueAsString(oAuth2User.getAttributes()));
        } catch (Exception exception) {
          exception.printStackTrace();
        }

        String registrationId = request.getClientRegistration().getRegistrationId();

        String id = "";
        String userNickname = "";

        if (registrationId.equals("naver")) {
          Map<String, String> response = (Map<String, String>) oAuth2User.getAttribute("response");

          id = response.get("id");
          userNickname = response.get("nickname");
        }

        if (registrationId.equals("kakao")) {
          Map<String, String> response = (Map<String, String>) oAuth2User.getAttribute("response");

          id = response.get("id");
          userNickname = response.get("nickname");
        }

        

        boolean existedId = userRepository.existsById(id);
        if (!existedId) {
          UserEntity userEntity = new UserEntity(id, userNickname);
          userRepository.save(userEntity);
        }
    
    return new ApplicationOAuth2User(id, oAuth2User.getAttributes());

  }
    
}
