package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.and.platforms.platforms.platforms;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.and.platforms.platforms.Platform;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.and.platforms.platforms.PlatformId;

@Value(staticConstructor = "of")
public class TakaroCommunityPlatform implements Platform {

    @NonNull
    PlatformId platformId = PlatformId.of("a4953d76-937a-40b4-9bbe-d77936bddbcb");

    @NonNull
    String displayedName = "Takaro Community";

}
