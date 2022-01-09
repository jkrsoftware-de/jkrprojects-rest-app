package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.out.platform.authorization.persistence.port;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.client.address.ChatClientAddress;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platform.authorization.PlatformAuthorization;

import java.util.Set;

public interface PlatformAuthorizationPersistencePort {

    Set<PlatformAuthorization> listPlatformAuthorizations(@NonNull ChatClientAddress byChatClientAddress);

    void save(@NonNull PlatformAuthorization entity);

}
