package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.out.platforms.persistence.port;

import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.platforms.Platform;

import java.util.Set;

public interface ChatPlatformsPersistencePort {

    Set<Platform> listAvailablePlatforms();

}
