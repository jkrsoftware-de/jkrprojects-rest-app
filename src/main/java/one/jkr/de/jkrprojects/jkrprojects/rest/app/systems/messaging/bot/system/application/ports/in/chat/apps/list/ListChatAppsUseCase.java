package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.chat.apps.list;

import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.ChatApp;

import java.util.Set;

public interface ListChatAppsUseCase {

    Set<ChatApp> listAvailableChatApps();

}
