package com.morenoagudo.email_service.controllers;

import com.morenoagudo.email_service.application.EmailSenderService;
import com.morenoagudo.email_service.core.EmailRequest;
import com.morenoagudo.email_service.core.exceptions.EmailServiceExceptions;
import jakarta.annotation.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmailSenderController {
    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PatchMapping()
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
        try {
            this.emailSenderService.sendEmail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok("Email send sucessfully");
        } catch (EmailServiceExceptions ex){
            return.ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sendind Email");

        }
    }

}
