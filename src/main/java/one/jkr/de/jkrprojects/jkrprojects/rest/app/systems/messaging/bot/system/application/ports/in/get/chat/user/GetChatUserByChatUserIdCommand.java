package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.get.chat.user;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.user.ChatUserId;

@Value(staticConstructor = "of")
public class GetChatUserByChatUserIdCommand {

    @NonNull
    ChatUserId chatUserId;

}
