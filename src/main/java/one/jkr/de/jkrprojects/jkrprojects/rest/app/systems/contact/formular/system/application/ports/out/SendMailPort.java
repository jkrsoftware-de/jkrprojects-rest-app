package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.application.ports.out;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.domain.EmailAddress;

public interface SendMailPort {

    void sendEmail(@NonNull EmailAddress receiver, @NonNull String subject, @NonNull String message);

}
