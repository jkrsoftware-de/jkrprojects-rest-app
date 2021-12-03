package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.user;

import lombok.NonNull;
import lombok.Value;

import java.time.OffsetDateTime;

@Value
public class ChatUser {

    @NonNull
    ChatUserId chatUserId;

    @NonNull
    OffsetDateTime createdAt;

    @NonNull
    OffsetDateTime lastModified;

}
