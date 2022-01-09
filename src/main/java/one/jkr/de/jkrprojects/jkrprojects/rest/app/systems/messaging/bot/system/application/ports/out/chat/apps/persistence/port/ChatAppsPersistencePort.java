package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.out.chat.apps.persistence.port;

import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.ChatApp;

import java.util.Set;

public interface ChatAppsPersistencePort {

    Set<ChatApp> listAvailableChatApps();

}
