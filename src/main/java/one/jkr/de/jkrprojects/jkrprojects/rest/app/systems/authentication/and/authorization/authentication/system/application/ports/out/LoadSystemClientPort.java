package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.application.ports.out;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.system.client.SystemClient;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.system.client.SystemClientId;

import java.util.Optional;

public interface LoadSystemClientPort {

    Optional<SystemClient> getSystemClient(@NonNull SystemClientId systemClientId);

}
