package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.application.ports.in;

import lombok.NonNull;

public interface SendEmailUseCase {

    void sendEmail(@NonNull SendEmailCommand command);

}
