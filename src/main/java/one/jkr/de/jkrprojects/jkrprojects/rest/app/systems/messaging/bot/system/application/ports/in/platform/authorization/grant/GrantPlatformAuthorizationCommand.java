package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.platform.authorization.grant;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.and.platforms.platforms.PlatformId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.user.ChatUserId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.user.platform.authorization.jwt.refresh.token.JwtRefreshToken;

@Value(staticConstructor = "of")
public class GrantPlatformAuthorizationCommand {

    @NonNull
    PlatformId platformId;

    @NonNull
    ChatUserId chatUserId;

    @NonNull
    JwtRefreshToken jwtRefreshToken;

}
