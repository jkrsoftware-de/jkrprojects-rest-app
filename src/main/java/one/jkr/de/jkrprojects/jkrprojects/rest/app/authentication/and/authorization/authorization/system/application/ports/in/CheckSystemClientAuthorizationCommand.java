package one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.application.ports.in;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.jwt.JwtAuthenticationToken;

@Value
public class CheckSystemClientAuthorizationCommand {

    @NonNull
    JwtAuthenticationToken jwtAuthenticationToken;

}
