package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.service.process.chat.message;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.process.chat.message.ProcessChatMessageCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.in.process.chat.message.ProcessChatMessageUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.out.platform.authorization.gather.user.authorization.GatherUserAuthorizationTokenForPlatformPort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.application.ports.out.platform.authorization.persistence.port.PlatformAuthorizationPersistencePort;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProcessChatMessageService implements ProcessChatMessageUseCase {

    @NonNull
    private final PlatformAuthorizationPersistencePort platformAuthorizationPersistencePort;

    @NonNull
    private final GatherUserAuthorizationTokenForPlatformPort gatherUserAuthorizationTokenForPlatformPort;

    @Override
    public void processMessage(@NonNull ProcessChatMessageCommand command) {

    }

}
