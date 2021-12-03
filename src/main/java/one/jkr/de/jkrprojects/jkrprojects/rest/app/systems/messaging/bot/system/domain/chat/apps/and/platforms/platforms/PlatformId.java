package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.and.platforms.platforms;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value(staticConstructor = "of")
public class PlatformId {

    @NonNull
    UUID id;

    public static PlatformId of(@NonNull String uuid) {
        return PlatformId.of(UUID.fromString(uuid));
    }

}
