package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.client.address.whatsapp;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.apps.ChatAppId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.client.address.ChatClientAddress;

@Value(staticConstructor = "of")
public class WhatsAppChatClientAddress implements ChatClientAddress {

    @NonNull
    ChatAppId chatAppId = ChatAppId.of("TWILIO-WHATSAPP");

    @NonNull
    TelephoneNumber telephoneNumber;

    @Override
    public String getAddress() {
        return telephoneNumber.getTelephoneNumber();
    }

}
