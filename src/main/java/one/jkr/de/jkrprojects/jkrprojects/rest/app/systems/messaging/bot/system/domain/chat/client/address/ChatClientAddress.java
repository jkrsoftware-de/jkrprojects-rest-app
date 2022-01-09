package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.client.address;

import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.ChatAppId;

public interface ChatClientAddress {

    ChatAppId getChatAppId();

    String getAddress();

}
