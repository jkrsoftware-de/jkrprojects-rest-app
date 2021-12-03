package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.adapters.in.web.payload.data.classes.get.current.authentication.informations;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.jwt.subjects.TypeOfClient;

import java.util.UUID;

@Value
public class GetInformationsAboutCurrentAuthenticationResponse {

    @NonNull
    TypeOfClient typeOfClient;

    @NonNull
    UUID clientIdentifier;

}
