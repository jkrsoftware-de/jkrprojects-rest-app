package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.adapters.in.web;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.adapters.in.web.payload.data.classes.SendContactMessageRequestPayload;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.application.ports.in.SendContactMessageUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.application.ports.in.SubmitContactMessageCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.domain.ContactMessage;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.domain.EmailAddress;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.domain.Submitter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ContactFormularRestController {

    @NonNull
    private final SendContactMessageUseCase sendContactMessageUseCase;

    @RequestMapping(value = "/contact-formular-system/send-contact-message", method = RequestMethod.POST)
    public ResponseEntity<?> sendContactMessage(@RequestBody @NonNull SendContactMessageRequestPayload payload) {
        // TODO: introduce Captcha Validation.
        sendContactMessageUseCase.submitContactMessage(
                SubmitContactMessageCommand.of(
                        ContactMessage.of(
                                Submitter.of(
                                        payload.getSubmitterName(), EmailAddress.of(payload.getSubmitterEmailAddress())
                                ), payload.getSubject(), payload.getContent()
                        )
                )
        );
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
