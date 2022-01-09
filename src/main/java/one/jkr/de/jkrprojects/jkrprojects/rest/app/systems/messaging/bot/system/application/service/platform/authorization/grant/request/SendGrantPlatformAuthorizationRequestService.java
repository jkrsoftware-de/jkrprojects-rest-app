package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.service.platform.authorization.grant.request;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.platform.authorization.grant.GrantPlatformAuthorizationCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.platform.authorization.grant.request.GrantPlatformAuthorizationRequestUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.out.platform.authorization.persistence.port.PlatformAuthorizationPersistencePort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platform.authorization.PlatformAuthorization;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platform.authorization.PlatformAuthorizationId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class SendGrantPlatformAuthorizationRequestService implements GrantPlatformAuthorizationRequestUseCase {

    @NonNull
    private final PlatformAuthorizationPersistencePort persistencePort;

    @Override
    public Optional<PlatformAuthorizationId> grantPlatformAuthorization(@NonNull GrantPlatformAuthorizationCommand command) {
        return Optional.empty();
    }

    private PlatformAuthorization buildEntity(GrantPlatformAuthorizationCommand command) {

    }

}
