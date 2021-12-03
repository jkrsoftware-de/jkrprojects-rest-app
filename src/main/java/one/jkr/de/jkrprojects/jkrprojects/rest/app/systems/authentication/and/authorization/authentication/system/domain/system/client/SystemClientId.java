package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.system.client;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class SystemClientId {

    @NonNull
    UUID id;

}
