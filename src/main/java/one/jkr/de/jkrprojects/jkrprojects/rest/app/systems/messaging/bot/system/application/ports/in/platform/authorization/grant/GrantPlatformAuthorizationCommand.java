package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.platform.authorization.grant;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platforms.PlatformId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.client.address.ChatClientAddress;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platform.authorization.jwt.token.JwtRefreshToken;

@Value(staticConstructor = "of")
public class GrantPlatformAuthorizationCommand {

    @NonNull
    ChatClientAddress chatClientAddress;

    @NonNull
    PlatformId platformId;

    @NonNull
    JwtRefreshToken jwtRefreshToken;

}
