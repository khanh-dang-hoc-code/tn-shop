package com.tech.tnshop.service.impl;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.tech.tnshop.exception.InternalServerException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Service
@RequiredArgsConstructor
public class EmailService {

    private final SendGrid sendGrid;

    public void sendEmail() throws IOException {
        Email from = new Email("khanhk56a12@gmail.com");
        String subject = "Thanks for user TNShop service";
        Email to = new Email("khanhkhanhitit@gmail.com"); // replace with recipient email
        Content content = new Content("text/plain", "Wellcome Ngoc to TNShop");
        Mail mail = new Mail(from, subject, to, content);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sendGrid.api(request);
        } catch (IOException ex) {
            throw new InternalServerException(ex.getMessage());
        }
    }
}
