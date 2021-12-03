package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.process.chat.message;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.client.address.ChatClientAddress;

@Value(staticConstructor = "of")
public class ProcessChatMessageCommand {

    @NonNull
    ChatClientAddress chatClientAddress;

    @NonNull
    String message;

}
