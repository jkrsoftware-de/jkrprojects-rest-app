package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.domain;

import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class EmailAddress {

    @NonNull
    String address;

}
