package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.platform.authorization.grant.request;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.platform.authorization.grant.GrantPlatformAuthorizationCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platform.authorization.PlatformAuthorizationId;

import java.util.Optional;

public interface GrantPlatformAuthorizationRequestUseCase {

    Optional<PlatformAuthorizationId> grantPlatformAuthorization(@NonNull GrantPlatformAuthorizationCommand command);

}
