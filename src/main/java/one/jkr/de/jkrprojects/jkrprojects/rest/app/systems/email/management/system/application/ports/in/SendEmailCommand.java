package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.application.ports.in;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.domain.EmailAddress;

@Value(staticConstructor = "of")
public class SendEmailCommand {

    @NonNull
    EmailAddress receiver;

    @NonNull
    String subject;

    @NonNull
    String message;

}
