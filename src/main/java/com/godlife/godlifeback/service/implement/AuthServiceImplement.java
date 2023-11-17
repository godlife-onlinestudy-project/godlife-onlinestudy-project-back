package com.godlife.godlifeback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.godlife.godlifeback.dto.request.auth.SignInEmailCheckRequestDto;
import com.godlife.godlifeback.dto.request.auth.SignInRequestDto;
import com.godlife.godlifeback.dto.request.auth.SignUpRequestDto;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.auth.SignInEmailcheckResponseDto;
import com.godlife.godlifeback.dto.response.auth.SignInResponseDto;
import com.godlife.godlifeback.dto.response.auth.SignUpResponseDto;
import com.godlife.godlifeback.entity.UserEntity;
import com.godlife.godlifeback.provider.JwtProvider;
import com.godlife.godlifeback.repository.UserRepository;
import com.godlife.godlifeback.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService{
    
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignInEmailcheckResponseDto> signInEmailCheck(SignInEmailCheckRequestDto dto) {
        try {
            String email = dto.getUserEmail();

            boolean existedEmail = userRepository.existsByEmail(email);
            if (!existedEmail) return SignInResponseDto.signInFailed();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        return SignInEmailcheckResponseDto.success();
    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        
        String token = null;

        try {
            String email = dto.getUserEmail();

            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return SignInResponseDto.signInFailed();

            String password = dto.getUserPassword();
            String encodedPassword = userEntity.getUserPassword();

            boolean isMatched = passwordEncoder.matches(password, encodedPassword);
            if (!isMatched) return SignInResponseDto.signInFailed();

            token = jwtProvider.create(email);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignInResponseDto.success(token);
    }

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {

        try {

            String userEmail = dto.getUserEmail();

            boolean hasEmail = userRepository.existsByEmail(userEmail);
            if (hasEmail) return SignUpResponseDto.duplicateUserEmail();


            String password = dto.getUserPassword();
            String encodedPassword = passwordEncoder.encode(password);

            dto.setUserPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.success();
    }


}
