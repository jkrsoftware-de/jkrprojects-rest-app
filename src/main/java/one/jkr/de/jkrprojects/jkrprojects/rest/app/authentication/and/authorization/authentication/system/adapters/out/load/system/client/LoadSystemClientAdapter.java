package one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.adapters.out.load.system.client;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.adapters.out.load.system.client.internal.database.InternalSystemClientDatabase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.application.ports.out.LoadSystemClientPort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.system.client.SystemClient;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.system.client.SystemClientId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LoadSystemClientAdapter implements LoadSystemClientPort {

    @NonNull
    private final InternalSystemClientDatabase internalSystemClientDatabase;

    @Override
    public Optional<SystemClient> getSystemClient(@NonNull SystemClientId systemClientId) {
        return internalSystemClientDatabase.getSystemClient(systemClientId);
    }

}
