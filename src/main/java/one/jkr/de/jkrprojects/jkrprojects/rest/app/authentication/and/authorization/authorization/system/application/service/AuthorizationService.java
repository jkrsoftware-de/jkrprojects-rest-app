package one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.application.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.jwt.subjects.TypeOfClient;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.successful.authentication.response.SuccessfulAuthenticationResponse;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.application.ports.in.AuthorizationUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.application.ports.in.CheckAuthorizationForCompanyCodeCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.application.ports.in.CheckSystemClientAuthorizationCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.application.ports.out.AuthenticateClientPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthorizationService implements AuthorizationUseCase {

    @NonNull
    private final AuthenticateClientPort authenticateClientPort;

    @Override
    public boolean isAuthorized(@NonNull CheckAuthorizationForCompanyCodeCommand command) {

        Optional<SuccessfulAuthenticationResponse> successfulAuthenticationResponse =
                authenticateClientPort.checkAuthorization(command.getJwtAuthenticationToken());

        if (successfulAuthenticationResponse.isPresent()) {
            SuccessfulAuthenticationResponse response = successfulAuthenticationResponse.get();

            if (response.getTypeOfClient().equals(TypeOfClient.SYSTEM_USER_CLIENT)) {
                return true;
            }
            if (response.getTypeOfClient().equals(TypeOfClient.COMPANY_CODE_USER_CLIENT)) {
                return response.getClientIdentifier().equals(command.getCompanyCodeId().getId());
            }
        }
        return false;
    }

    @Override
    public boolean isAuthorized(@NonNull CheckSystemClientAuthorizationCommand command) {
        Optional<SuccessfulAuthenticationResponse> successfulAuthenticationResponse =
                authenticateClientPort.checkAuthorization(command.getJwtAuthenticationToken());
        return successfulAuthenticationResponse.map(
                authenticationResponse -> authenticationResponse.getTypeOfClient().equals(TypeOfClient.SYSTEM_USER_CLIENT)).orElse(false);
    }

}
