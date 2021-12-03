package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.application.ports.in;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class AuthenticateViaSystemClientCredentialsCommand {

    @NonNull
    UUID systemClientId;

    @NonNull
    String systemClientSecret;

}
