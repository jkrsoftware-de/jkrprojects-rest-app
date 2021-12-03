package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.application.service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.application.ports.in.SendEmailCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.application.ports.in.SendEmailUseCase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class SendEmailService implements SendEmailUseCase {

    private static final String LOG_PREFIX = "[Send E-Mail Service]: ";

    @NonNull
    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @NonNull
    private final String emailAddressOfSender;

    public SendEmailService(@NonNull AmazonSimpleEmailService amazonSimpleEmailService,
                            @NonNull @Value("${email-management-service.send-mails.email-sender}") String emailAddressOfSender) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
        this.emailAddressOfSender = emailAddressOfSender;
    }

    @Override
    public void sendEmail(@NonNull SendEmailCommand command) {
        log.info(LOG_PREFIX + "Send E-Mail with Subject \"{}\" to: \"{}\"", command.getSubject(), command.getReceiver());
        amazonSimpleEmailService.sendEmail(
                new SendEmailRequest(emailAddressOfSender,
                        new Destination(List.of(command.getReceiver().getAddress())),
                        new Message(
                                new Content(command.getSubject()), new Body(new Content(command.getMessage()))
                        ))
        );
    }

}
