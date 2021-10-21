package one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.adapters.out.load.system.client.internal.database;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.system.client.SystemClient;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.system.client.SystemClientId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.system.client.SystemClientSecret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Component
public class InternalSystemClientDatabase {

    private final Set<SystemClient> systemClients;

    @Autowired
    public InternalSystemClientDatabase(
            @Value("${authentication-system.system-client-tokens.jkr-personal-access}") String tokenOfJkrPersonalAccessSystemClient) {
        this.systemClients = Set.of(
                new SystemClient(
                        new SystemClientId(UUID.fromString("640098bb-27e0-428f-a5df-b5370353fb30")), "jkr-personal-access",
                        new SystemClientSecret(tokenOfJkrPersonalAccessSystemClient)
                )
        );
    }

    public Optional<SystemClient> getSystemClient(@NonNull SystemClientId systemClientId) {
        return systemClients.stream()
                .filter(systemClient -> Objects.equals(systemClient.getSystemClientId(), systemClientId))
                .findFirst();
    }

}
