package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.successful.authentication.response;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.jwt.subjects.TypeOfClient;

import java.util.UUID;

@Value
public class SuccessfulAuthenticationResponse {

    @NonNull
    TypeOfClient typeOfClient;

    UUID clientIdentifier;

}
