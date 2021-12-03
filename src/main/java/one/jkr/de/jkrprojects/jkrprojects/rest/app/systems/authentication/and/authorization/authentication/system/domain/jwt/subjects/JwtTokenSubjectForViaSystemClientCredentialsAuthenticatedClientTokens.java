package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.jwt.subjects;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class JwtTokenSubjectForViaSystemClientCredentialsAuthenticatedClientTokens implements JwtTokenSubject {

    TypeOfClient typeOfClient = TypeOfClient.SYSTEM_USER_CLIENT;

    @NonNull
    UUID clientIdentifier;

}
