package one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.adapters.in.internal.rest.controllers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.jwt.JwtAuthenticationToken;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.adapters.in.internal.InternalAuthorizationSystemAdapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.adapters.in.internal.rest.controllers.rest.exceptions.JwtTokenMalformedRestException;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.adapters.in.internal.rest.controllers.rest.exceptions.NoAuthorizationRestException;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class InternalAuthorizationSystemAdapterForRestControllers {

    @NonNull
    private final InternalAuthorizationSystemAdapter internalAuthorizationSystemAdapter;

    public void checkAuthorizationForCompanyCode(@NonNull String authorizationHeader,
                                                 @NonNull UUID companyCodeId) throws NoAuthorizationRestException {
        authorizationHeader = removeBearerPrefixFromAuthorizationHeader(authorizationHeader);
        throwIfAuthorizationHeaderContentIsNotAValidJwtToken(authorizationHeader);
        throwIfUnauthorized(
                internalAuthorizationSystemAdapter.isAuthorizedForCompanyCode(
                        new JwtAuthenticationToken(authorizationHeader),
                        new CompanyCodeId(companyCodeId))
        );
    }

    public void checkSystemClientAuthorization(@NonNull String authorizationHeader) throws NoAuthorizationRestException {
        authorizationHeader = removeBearerPrefixFromAuthorizationHeader(authorizationHeader);
        throwIfAuthorizationHeaderContentIsNotAValidJwtToken(authorizationHeader);
        throwIfUnauthorized(
                internalAuthorizationSystemAdapter.isAuthorizedAsSystemClient(new JwtAuthenticationToken(authorizationHeader)));
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

    private void throwIfUnauthorized(boolean isAuthorized) throws NoAuthorizationRestException {
        if (!isAuthorized) {
            throw new NoAuthorizationRestException();
        }
    }

}
