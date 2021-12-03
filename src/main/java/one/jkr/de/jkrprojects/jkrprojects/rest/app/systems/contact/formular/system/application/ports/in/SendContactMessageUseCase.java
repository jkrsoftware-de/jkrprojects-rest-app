package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.application.ports.in;

import lombok.NonNull;

public interface SendContactMessageUseCase {

    void submitContactMessage(@NonNull SubmitContactMessageCommand command);

}
