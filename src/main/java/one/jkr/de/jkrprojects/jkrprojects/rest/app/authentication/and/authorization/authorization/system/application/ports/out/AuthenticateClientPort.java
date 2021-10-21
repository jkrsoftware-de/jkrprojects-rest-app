package one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.application.ports.out;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.jwt.JwtAuthenticationToken;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.successful.authentication.response.SuccessfulAuthenticationResponse;

import java.util.Optional;

public interface AuthenticateClientPort {

    Optional<SuccessfulAuthenticationResponse> checkAuthorization(@NonNull JwtAuthenticationToken jwtAuthenticationToken);

}
