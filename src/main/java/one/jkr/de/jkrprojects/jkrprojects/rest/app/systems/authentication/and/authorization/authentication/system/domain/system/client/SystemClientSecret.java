package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.system.client;

import lombok.NonNull;
import lombok.Value;

@Value
public class SystemClientSecret {

    @NonNull
    String secret;

}
