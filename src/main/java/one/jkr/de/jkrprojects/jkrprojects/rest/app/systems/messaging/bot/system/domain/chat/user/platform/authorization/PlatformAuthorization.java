package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.user.platform.authorization;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.and.platforms.platforms.PlatformId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.user.ChatUserId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.user.platform.authorization.jwt.refresh.token.JwtRefreshToken;

import java.time.OffsetDateTime;

@Value(staticConstructor = "of")
public class PlatformAuthorization {

    @NonNull
    PlatformAuthorizationId platformAuthorizationId;

    @NonNull
    PlatformId ofPlatform;

    @NonNull
    ChatUserId forChatUser;

    @NonNull
    JwtRefreshToken jwtRefreshToken;

    @NonNull
    OffsetDateTime authorizedAt;

    @NonNull
    OffsetDateTime lastRefresh;

}
