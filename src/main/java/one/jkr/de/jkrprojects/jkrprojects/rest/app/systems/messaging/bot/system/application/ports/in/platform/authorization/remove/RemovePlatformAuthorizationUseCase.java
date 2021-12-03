package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.platform.authorization.remove;

import lombok.NonNull;

public interface RemovePlatformAuthorizationUseCase {

    boolean removePlatformAuthorization(@NonNull RemovePlatformAuthorizationCommand command);

}
