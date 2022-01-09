package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.messaging.bot.system.domain.chat.client.address.whatsapp;

import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class TelephoneNumber {

    @NonNull
    String telephoneNumber;

}
