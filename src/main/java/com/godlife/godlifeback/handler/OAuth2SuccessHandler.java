package com.godlife.godlifeback.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.godlife.godlifeback.entity.ApplicationOAuth2User;
import com.godlife.godlifeback.provider.JwtProvider;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
  
  private final JwtProvider jwtProvider;

  @Override
  public void onAuthenticationSuccess(
    HttpServletRequest request, 
    HttpServletResponse response, 
    Authentication authentication
  ) throws IOException {

    ApplicationOAuth2User oAuth2User = (ApplicationOAuth2User) authentication.getPrincipal();
    String id = oAuth2User.getName();
    String token = jwtProvider.create(id);

    response.sendRedirect("https://www.godlifestudy.co.kr/oauth/"+token+"/"+18000);
  }

}