package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.domain;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.domain.EmailAddress;

@Value(staticConstructor = "of")
public class Submitter {

    @NonNull
    String name;

    @NonNull
    EmailAddress emailAddress;

}
