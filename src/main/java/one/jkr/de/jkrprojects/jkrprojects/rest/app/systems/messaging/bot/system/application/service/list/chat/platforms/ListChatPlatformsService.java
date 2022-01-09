package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.service.list.chat.platforms;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.chat.platforms.list.ListChatPlatformsUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.out.platforms.persistence.port.ChatPlatformsPersistencePort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platforms.Platform;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class ListChatPlatformsService implements ListChatPlatformsUseCase {

    @NonNull
    private final ChatPlatformsPersistencePort persistencePort;

    @Override
    public Set<Platform> listAvailablePlatforms() {
        return persistencePort.listAvailablePlatforms();
    }
    
}
