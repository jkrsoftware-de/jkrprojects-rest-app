package one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.adapters.out.authenticate.client.port;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.adapters.in.internal.InternalAuthenticationSystemAdapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.jwt.JwtAuthenticationToken;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.successful.authentication.response.SuccessfulAuthenticationResponse;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.application.ports.out.AuthenticateClientPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthenticateClientAdapter implements AuthenticateClientPort {

    @NonNull
    private final InternalAuthenticationSystemAdapter internalAuthenticationSystemAdapter;

    @Override
    public Optional<SuccessfulAuthenticationResponse> checkAuthorization(@NonNull JwtAuthenticationToken jwtAuthenticationToken) {
        return internalAuthenticationSystemAdapter.checkAuthentication(jwtAuthenticationToken);
    }

}
