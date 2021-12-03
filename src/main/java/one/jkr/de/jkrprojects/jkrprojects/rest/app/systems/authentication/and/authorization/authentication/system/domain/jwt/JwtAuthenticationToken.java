package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.jwt;

import lombok.NonNull;
import lombok.Value;

@Value
public class JwtAuthenticationToken {

    @NonNull
    String jwtToken;

}
