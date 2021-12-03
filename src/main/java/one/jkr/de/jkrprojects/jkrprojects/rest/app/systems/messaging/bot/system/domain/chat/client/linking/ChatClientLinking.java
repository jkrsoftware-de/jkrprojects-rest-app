package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.client.linking;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.client.address.ChatClientAddress;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.user.ChatUserId;

import java.time.OffsetDateTime;

@Value(staticConstructor = "of")
public class ChatClientLinking {

    @NonNull
    ChatClientLinkingId chatClientLinkingId;

    @NonNull
    ChatUserId chatUserId;

    @NonNull
    ChatClientAddress chatClientAddress;

    @NonNull
    OffsetDateTime createdAt;

}
