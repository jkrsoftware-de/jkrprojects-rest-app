package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.domain;

import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class ContactMessage {

    @NonNull
    Submitter submitter;

    @NonNull
    String subject;

    @NonNull
    String content;

}
