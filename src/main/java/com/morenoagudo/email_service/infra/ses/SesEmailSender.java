package com.morenoagudo.email_service.infra.ses;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.workmail.model.EmailAddressInUseException;
import com.morenoagudo.email_service.adapters.EmailSenderGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderGateway {
    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService){
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        sendEmailRequest request = new sendEmailRequest()
                .withSource("renatomorenoagudo2@gmail.com")
                .withDestination(new Destination().withToAdress(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody().withText(body).withHtml);
    try {
        this.amazonSimpleEmailService.sendEmail(request);
    }
    catch (AmazonClientException exception){
        throw new EmailAddressInUseException("Failure while sending Email");
    }

    }
}
