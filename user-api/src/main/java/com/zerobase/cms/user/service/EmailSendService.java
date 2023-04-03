package com.zerobase.cms.user.service;

import com.zerobase.cms.user.client.MailgunClient;
import com.zerobase.cms.user.client.mailgun.SendMailForm;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSendService {
    private final MailgunClient mailgunClient;

    public Response sendEmail(){
        SendMailForm form=SendMailForm.builder()
                .from("${send.from}")
                .to("${send.to}")
                .subject("Test email form zero base")
                .text("my service test")
                .build();

        return mailgunClient.sendEmail(form);
    }

}
