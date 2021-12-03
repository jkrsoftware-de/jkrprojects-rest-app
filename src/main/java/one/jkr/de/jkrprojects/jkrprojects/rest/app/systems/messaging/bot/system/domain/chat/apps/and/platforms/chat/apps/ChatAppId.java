package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.and.platforms.chat.apps;

import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class ChatAppId {

    @NonNull
    String id;

}
