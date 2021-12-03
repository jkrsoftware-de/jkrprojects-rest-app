package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.create.chat.user;

import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.user.ChatUserId;

import java.util.Optional;

public interface CreateChatUserUseCase {

    Optional<ChatUserId> createUser();

}
