package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authorization.system.adapters.in.internal;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.jwt.JwtAuthenticationToken;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authorization.system.application.ports.in.AuthorizationUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authorization.system.application.ports.in.CheckAuthorizationForCompanyCodeCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authorization.system.application.ports.in.CheckSystemClientAuthorizationCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InternalAuthorizationSystemAdapter {

    @NonNull
    private final AuthorizationUseCase authorizationUseCase;

    public boolean isAuthorizedForCompanyCode(@NonNull JwtAuthenticationToken jwtAuthenticationToken,
                                              @NonNull CompanyCodeId companyCodeId) {
        return authorizationUseCase.isAuthorized(
                new CheckAuthorizationForCompanyCodeCommand(jwtAuthenticationToken, companyCodeId)
        );
    }

    public boolean isAuthorizedAsSystemClient(@NonNull JwtAuthenticationToken jwtAuthenticationToken) {
        return authorizationUseCase.isAuthorized(
                new CheckSystemClientAuthorizationCommand(jwtAuthenticationToken)
        );
    }

}
