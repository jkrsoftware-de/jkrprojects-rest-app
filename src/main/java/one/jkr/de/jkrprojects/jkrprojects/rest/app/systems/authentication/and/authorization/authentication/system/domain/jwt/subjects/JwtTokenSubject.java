package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.jwt.subjects;

import java.util.UUID;

public interface JwtTokenSubject {

    TypeOfClient getTypeOfClient();

    UUID getClientIdentifier();

}
