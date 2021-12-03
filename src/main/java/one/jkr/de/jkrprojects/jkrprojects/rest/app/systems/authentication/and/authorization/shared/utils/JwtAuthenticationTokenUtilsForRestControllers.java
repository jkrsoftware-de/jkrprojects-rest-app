package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.shared.utils;

import lombok.NonNull;
import lombok.SneakyThrows;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.jwt.JwtAuthenticationToken;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authorization.system.adapters.in.internal.rest.controllers.rest.exceptions.JwtTokenMalformedRestException;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationTokenUtilsForRestControllers {

    public JwtAuthenticationToken getJwtAuthenticationTokenIfValidOrThrowRestException(@NonNull String authorizationHeader) {
        authorizationHeader = removeBearerPrefixFromAuthorizationHeader(authorizationHeader);
        throwIfAuthorizationHeaderContentIsNotAValidJwtToken(authorizationHeader);
        return new JwtAuthenticationToken(authorizationHeader);
    }

    private String removeBearerPrefixFromAuthorizationHeader(String authorizationHeader) {
        return authorizationHeader.replace("Bearer ", "");
    }

    @SneakyThrows
    private void throwIfAuthorizationHeaderContentIsNotAValidJwtToken(String authorizationHeader) {
        if (!authorizationHeader.matches("^[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_.+/=]*$")) {
            throw new JwtTokenMalformedRestException();
        }
    }

}
