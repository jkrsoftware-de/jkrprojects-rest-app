package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.adapters.in.web.payload.data.classes.authenticate.via.system.client.credentials;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class AuthenticateViaSystemClientCredentialsRequest {

    @NonNull
    UUID systemClientId;

    @NonNull
    String systemClientSecret;

}
