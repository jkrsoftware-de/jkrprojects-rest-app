package one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.adapters.in.internal.rest.controllers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.jwt.JwtAuthenticationToken;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.adapters.in.internal.InternalAuthorizationSystemAdapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.adapters.in.internal.rest.controllers.rest.exceptions.NoAuthorizationRestException;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.shared.utils.JwtAuthenticationTokenUtilsForRestControllers;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class InternalAuthorizationSystemAdapterForRestControllers {

    @NonNull
    private final InternalAuthorizationSystemAdapter internalAuthorizationSystemAdapter;

    @NonNull
    private final JwtAuthenticationTokenUtilsForRestControllers jwtAuthenticationTokenUtilsForRestControllers;

    public void checkAuthorizationForCompanyCode(@NonNull String authorizationHeader,
                                                 @NonNull UUID companyCodeId) throws NoAuthorizationRestException {
        JwtAuthenticationToken jwtAuthenticationToken = jwtAuthenticationTokenUtilsForRestControllers
                .getJwtAuthenticationTokenIfValidOrThrowRestException(authorizationHeader);
        throwIfUnauthorized(
                internalAuthorizationSystemAdapter.isAuthorizedForCompanyCode(jwtAuthenticationToken, new CompanyCodeId(companyCodeId)));
    }

    public void checkSystemClientAuthorization(@NonNull String authorizationHeader) throws NoAuthorizationRestException {
        JwtAuthenticationToken jwtAuthenticationToken = jwtAuthenticationTokenUtilsForRestControllers
                .getJwtAuthenticationTokenIfValidOrThrowRestException(authorizationHeader);
        throwIfUnauthorized(internalAuthorizationSystemAdapter.isAuthorizedAsSystemClient(jwtAuthenticationToken));
    }


    private void throwIfUnauthorized(boolean isAuthorized) throws NoAuthorizationRestException {
        if (!isAuthorized) {
            throw new NoAuthorizationRestException();
        }
    }

}
