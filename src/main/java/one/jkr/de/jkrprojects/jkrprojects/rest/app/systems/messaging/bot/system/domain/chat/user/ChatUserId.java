package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.user;

import lombok.Value;

import javax.annotation.Nonnull;
import java.util.UUID;

@Value
public class ChatUserId {

    @Nonnull
    UUID id;

}
