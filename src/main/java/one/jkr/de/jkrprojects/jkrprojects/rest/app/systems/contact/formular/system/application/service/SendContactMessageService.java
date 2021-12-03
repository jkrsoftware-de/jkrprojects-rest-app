package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.application.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.application.ports.in.SendContactMessageUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.application.ports.in.SubmitContactMessageCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.application.ports.out.SendMailPort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.domain.ContactMessage;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.domain.mail.ContactMessageMail;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.domain.EmailAddress;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SendContactMessageService implements SendContactMessageUseCase {

    @NonNull
    private final SendMailPort sendMailPort;

    @Override
    public void submitContactMessage(@NonNull SubmitContactMessageCommand command) {
        ContactMessageMail contactMessageMail = ContactMessageMail.of(command.getContactMessage());
        sendMailPort.sendEmail(
            contactMessageMail.getReceiver(), contactMessageMail.getSubject(), contactMessageMail.getContent()
        );
    }

}
