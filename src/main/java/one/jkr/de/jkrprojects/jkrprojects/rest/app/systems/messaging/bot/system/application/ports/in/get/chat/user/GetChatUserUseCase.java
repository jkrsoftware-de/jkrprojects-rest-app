package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.get.chat.user;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.client.address.ChatClientAddress;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.user.ChatUserId;

import java.util.Optional;

public interface GetChatUserUseCase {

    Optional<ChatUserId> getChatUser(@NonNull GetChatUserByChatUserIdCommand command);

    Optional<ChatUserId> getChatUser(@NonNull ChatClientAddress chatClientAddress);

}
