package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.service.list.chat.apps;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.chat.apps.list.ListChatAppsUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.out.chat.apps.persistence.port.ChatAppsPersistencePort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.ChatApp;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class ListChatAppsService implements ListChatAppsUseCase {

    @NonNull
    private final ChatAppsPersistencePort persistencePort;

    @Override
    public Set<ChatApp> listAvailableChatApps() {
        return persistencePort.listAvailableChatApps();
    }

}
