package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.platform.authorization.grant;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platform.authorization.PlatformAuthorizationId;

import java.util.Optional;

public interface GrantPlatformAuthorizationUseCase {

    Optional<PlatformAuthorizationId> grantPlatformAuthorization(@NonNull GrantPlatformAuthorizationCommand command);

}
