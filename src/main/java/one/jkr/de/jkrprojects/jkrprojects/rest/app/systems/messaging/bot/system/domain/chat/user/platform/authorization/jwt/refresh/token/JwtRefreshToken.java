package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.user.platform.authorization.jwt.refresh.token;

import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class JwtRefreshToken {

    @NonNull
    String refreshToken;

}
