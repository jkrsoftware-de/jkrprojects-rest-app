package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.chat.platforms.list;

import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platforms.Platform;

import java.util.Set;

public interface ListChatPlatformsUseCase {

    Set<Platform> listAvailablePlatforms();

}
