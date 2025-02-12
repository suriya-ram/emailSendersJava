package com.example.SpringEmail.service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailService {

     @Autowired
    private JavaMailSender javaMailSender;

    public void SendEmail( String toEmail,
                           String body,
                           String subject){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("suriyaram234.zra@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        javaMailSender.send(message);
        System.out.println("mail sent");

    }


    public void SendEmailWithAttachment( String toEmail,
                           String body,
                           String subject,
                                         String attachment) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

        mimeMessageHelper.setFrom("suriyaram234.zra@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystem = new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);

        javaMailSender.send(mimeMessage);
        System.out.println(" mail sent with attachment");

    }

    }
