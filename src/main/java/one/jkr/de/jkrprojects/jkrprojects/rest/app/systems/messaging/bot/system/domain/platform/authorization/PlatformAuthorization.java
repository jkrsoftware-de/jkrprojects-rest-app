package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platform.authorization;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.client.address.ChatClientAddress;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platform.authorization.jwt.token.JwtRefreshToken;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platforms.PlatformId;

import java.time.OffsetDateTime;

@Value(staticConstructor = "of")
public class PlatformAuthorization {

    @NonNull
    PlatformAuthorizationId platformAuthorizationId;

    @NonNull
    ChatClientAddress ofChatClient;

    @NonNull
    PlatformId forPlatform;

    @NonNull
    JwtRefreshToken platformUserJwtRefreshToken;

    @NonNull
    OffsetDateTime authorizedAt;

    @NonNull
    OffsetDateTime lastRefresh;

}
