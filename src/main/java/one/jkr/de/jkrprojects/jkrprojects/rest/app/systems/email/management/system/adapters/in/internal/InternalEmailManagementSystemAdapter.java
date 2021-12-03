package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.adapters.in.internal;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.application.ports.in.SendEmailCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.application.ports.in.SendEmailUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.domain.EmailAddress;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class InternalEmailManagementSystemAdapter {

    @NonNull
    private final SendEmailUseCase sendEmailUseCase;

    public void sendEmail(@NonNull EmailAddress receiver, @NonNull String subject, @NonNull String message) {
        sendEmailUseCase.sendEmail(SendEmailCommand.of(receiver, subject, message));
    }

}
