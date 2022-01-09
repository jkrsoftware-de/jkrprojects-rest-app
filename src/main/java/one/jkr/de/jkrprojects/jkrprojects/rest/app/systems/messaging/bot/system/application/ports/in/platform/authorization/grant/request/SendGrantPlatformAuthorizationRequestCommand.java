package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.platform.authorization.grant.request;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.client.address.ChatClientAddress;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platform.authorization.jwt.token.JwtRefreshToken;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platforms.PlatformId;

@Value(staticConstructor = "of")
public class SendGrantPlatformAuthorizationRequestCommand {

    @NonNull
    ChatClientAddress sendRequestToChatClient;

    @NonNull
    PlatformId platformId;

    @NonNull
    JwtRefreshToken jwtRefreshToken;

}
