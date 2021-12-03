package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.application.ports.in;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.domain.ContactMessage;

@Value(staticConstructor = "of")
public class SubmitContactMessageCommand {

    @NonNull
    ContactMessage contactMessage;

}
