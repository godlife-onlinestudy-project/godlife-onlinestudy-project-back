package com.godlife.godlifeback.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MailProvider {

    private final JavaMailSender javaMailSender;

    public void sendMail(String email, String code) {
        
        
        // SimpleMailMessage (단순 텍스트 구성 메일 메시지 생성할 때 이용)
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        
        // 수신자 설정
        simpleMessage.setTo(email);
        
        // 메일 제목
        simpleMessage.setSubject("인증 코드");
        
        // 메일 내용
        simpleMessage.setText(code);
        
        // 메일 발송
        javaMailSender.send(simpleMessage);
    }   
}
