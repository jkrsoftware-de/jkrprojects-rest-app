package one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.application.ports.in;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.jwt.JwtAuthenticationToken;

@Value
public class CheckAuthenticationViaJwtAuthenticationTokenCommand {

    @NonNull
    JwtAuthenticationToken jwtAuthenticationToken;

}
