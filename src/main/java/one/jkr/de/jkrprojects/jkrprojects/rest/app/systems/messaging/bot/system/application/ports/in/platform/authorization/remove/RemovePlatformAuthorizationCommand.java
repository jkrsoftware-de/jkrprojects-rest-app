package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.platform.authorization.remove;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.user.platform.authorization.PlatformAuthorizationId;

@Value(staticConstructor = "of")
public class RemovePlatformAuthorizationCommand {

    @NonNull
    PlatformAuthorizationId platformAuthorizationId;

}
