package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.list.chat.apps.and.platforms;

import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.and.platforms.chat.apps.ChatApp;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.and.platforms.platforms.Platform;

import java.util.Set;

public interface ListChatAppsAndPlatformsUseCase {

    Set<Platform> listAvailablePlatforms();

    Set<ChatApp> listAvailableChatApps();

}
