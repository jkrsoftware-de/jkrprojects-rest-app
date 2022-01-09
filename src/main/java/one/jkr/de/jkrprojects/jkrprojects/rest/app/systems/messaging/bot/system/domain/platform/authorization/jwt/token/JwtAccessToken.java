package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platform.authorization.jwt.token;

import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class JwtAccessToken {

    @NonNull
    String accessToken;

}
