package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.adapters.in.web.payload.data.classes;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class SendContactMessageRequestPayload {

    @NonNull
    String submitterName;

    @NonNull
    String submitterEmailAddress;

    @NonNull
    String subject;

    @NonNull
    String content;

}
