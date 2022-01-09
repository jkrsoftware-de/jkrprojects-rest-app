package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platform.authorization;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value(staticConstructor = "of")
public class PlatformAuthorizationId {

    @NonNull
    UUID id;

}
