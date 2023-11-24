package com.godlife.godlifeback.provider;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MailProvider {

    private final JavaMailSender javaMailSender;
    private static final String senderEmail= "gohwangbong@gmail.com";

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

    public void createMail(String email, int number){

        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setFrom(senderEmail);
            message.setRecipients(MimeMessage.RecipientType.TO, email);
            message.setSubject("이메일 인증");
            String body = "";
            body += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
            body += "<h1>" + number + "</h1>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body,"UTF-8", "html");

        } catch (MessagingException exception) {
            exception.printStackTrace();
        }

        javaMailSender.send(message);
    }

}
