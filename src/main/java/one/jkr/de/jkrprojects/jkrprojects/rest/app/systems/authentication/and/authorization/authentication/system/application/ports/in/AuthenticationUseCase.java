package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.application.ports.in;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.jwt.JwtAuthenticationToken;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.successful.authentication.response.SuccessfulAuthenticationResponse;

import java.util.Optional;

public interface AuthenticationUseCase {

    Optional<JwtAuthenticationToken> authenticateClient(@NonNull AuthenticateViaCompanyCodeCommand command);

    Optional<JwtAuthenticationToken> authenticateClient(@NonNull AuthenticateViaCompanyCodeIdCommand command);

    Optional<JwtAuthenticationToken> authenticateClient(@NonNull AuthenticateViaSystemClientCredentialsCommand command);

    Optional<SuccessfulAuthenticationResponse> checkAuthentication(@NonNull CheckAuthenticationViaJwtAuthenticationTokenCommand command);

}
