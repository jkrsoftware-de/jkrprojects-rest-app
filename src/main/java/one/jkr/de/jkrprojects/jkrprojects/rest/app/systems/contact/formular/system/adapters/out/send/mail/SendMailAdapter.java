package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.adapters.out.send.mail;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.application.ports.out.SendMailPort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.adapters.in.internal.InternalEmailManagementSystemAdapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.domain.EmailAddress;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendMailAdapter implements SendMailPort {

    @NonNull
    private final InternalEmailManagementSystemAdapter internalEmailManagementSystemAdapter;

    @Override
    public void sendEmail(@NonNull EmailAddress receiver, @NonNull String subject, @NonNull String message) {
        internalEmailManagementSystemAdapter.sendEmail(receiver, subject, message);
    }

}
