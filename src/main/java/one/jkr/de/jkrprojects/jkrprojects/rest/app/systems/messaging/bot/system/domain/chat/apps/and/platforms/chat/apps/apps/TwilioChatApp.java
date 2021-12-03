package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.and.platforms.chat.apps.apps;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.and.platforms.chat.apps.ChatApp;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.and.platforms.chat.apps.ChatAppId;

@Value(staticConstructor = "of")
public class TwilioChatApp implements ChatApp {

    @NonNull
    ChatAppId id = ChatAppId.of("TWILIO");

    @NonNull
    String displayName = "Twilio Platform Connector";

}
