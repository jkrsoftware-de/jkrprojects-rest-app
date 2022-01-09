package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.out.platform.authorization.gather.user.authorization;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platform.authorization.PlatformAuthorization;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platform.authorization.jwt.token.JwtAccessToken;

import java.util.Optional;

public interface GatherUserAuthorizationTokenForPlatformPort {

    Optional<JwtAccessToken> getJwtAccessToken(@NonNull PlatformAuthorization platformAuthorization);

}
