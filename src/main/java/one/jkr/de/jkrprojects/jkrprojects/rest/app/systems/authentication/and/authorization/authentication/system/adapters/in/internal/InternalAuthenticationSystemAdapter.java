package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.adapters.in.internal;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.application.ports.in.AuthenticationUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.application.ports.in.CheckAuthenticationViaJwtAuthenticationTokenCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.jwt.JwtAuthenticationToken;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.successful.authentication.response.SuccessfulAuthenticationResponse;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class InternalAuthenticationSystemAdapter {

    @NonNull
    private final AuthenticationUseCase authenticationUseCase;

    public Optional<SuccessfulAuthenticationResponse> checkAuthentication(@NonNull JwtAuthenticationToken jwtAuthenticationToken) {
        return authenticationUseCase.checkAuthentication(
                new CheckAuthenticationViaJwtAuthenticationTokenCommand(jwtAuthenticationToken)
        );
    }

}
