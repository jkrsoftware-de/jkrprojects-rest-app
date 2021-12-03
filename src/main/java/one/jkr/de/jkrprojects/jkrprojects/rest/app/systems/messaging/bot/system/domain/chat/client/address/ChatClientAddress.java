package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.client.address;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.and.platforms.chat.apps.ChatAppId;

@Value(staticConstructor = "of")
public class ChatClientAddress {

    @NonNull
    ChatAppId ofChatApp;

    @NonNull
    String address;

}
