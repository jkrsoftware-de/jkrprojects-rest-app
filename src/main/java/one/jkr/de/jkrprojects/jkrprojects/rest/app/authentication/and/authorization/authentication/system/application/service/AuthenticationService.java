package one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.application.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.application.ports.in.AuthenticateViaCompanyCodeCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.application.ports.in.AuthenticateViaSystemClientCredentialsCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.application.ports.in.AuthenticationUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.application.ports.in.CheckAuthenticationViaJwtAuthenticationTokenCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.application.ports.out.LoadCompanyCodePort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.application.ports.out.LoadSystemClientPort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.application.utils.jwt.JwtTokenIssuer;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.application.utils.jwt.JwtTokenValidator;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.jwt.JwtAuthenticationToken;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.jwt.subjects.JwtTokenSubjectForViaCompanyCodeAuthenticatedClientTokens;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.jwt.subjects.JwtTokenSubjectForViaSystemClientCredentialsAuthenticatedClientTokens;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.jwt.subjects.TypeOfClient;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.successful.authentication.response.SuccessfulAuthenticationResponse;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.system.client.SystemClient;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.system.client.SystemClientId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.system.client.SystemClientSecret;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCode;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AuthenticationService implements AuthenticationUseCase {

    @NonNull
    private final LoadCompanyCodePort loadCompanyCodePort;

    @NonNull
    private final LoadSystemClientPort loadSystemClientPort;

    @NonNull
    private final JwtTokenIssuer jwtTokenIssuer;

    @NonNull
    private final JwtTokenValidator jwtTokenValidator;

    @Override
    public Optional<JwtAuthenticationToken> authenticateClient(@NonNull AuthenticateViaCompanyCodeCommand command) {
        Optional<CompanyCode> eventualExistingCompanyCode = loadCompanyCodePort.getCompanyCode(command.getCompanyCode());
        return eventualExistingCompanyCode.map(
                companyCode -> jwtTokenIssuer.issueToken(
                        new JwtTokenSubjectForViaCompanyCodeAuthenticatedClientTokens(companyCode.getCompanyCodeId().getId())
                )
        );
    }

    @Override
    public Optional<JwtAuthenticationToken> authenticateClient(@NonNull AuthenticateViaSystemClientCredentialsCommand command) {
        Optional<SystemClient> eventualExistingSystemClient = loadSystemClientPort
                .getSystemClient(new SystemClientId(command.getSystemClientId()));

        return eventualExistingSystemClient
                .filter(systemClient -> isTheSystemClientSecretCorrect(systemClient, command.getSystemClientSecret()))
                .map(systemClient ->
                        jwtTokenIssuer.issueToken(new JwtTokenSubjectForViaSystemClientCredentialsAuthenticatedClientTokens(
                                systemClient.getSystemClientId().getId()))
                );
    }

    private boolean isTheSystemClientSecretCorrect(SystemClient systemClient, String receivedSystemClientSecret) {
        return systemClient.getSystemClientSecret().equals(new SystemClientSecret(receivedSystemClientSecret));
    }

    @Override
    public Optional<SuccessfulAuthenticationResponse> checkAuthentication(
            @NonNull CheckAuthenticationViaJwtAuthenticationTokenCommand command) {
        Optional<Pair<TypeOfClient, UUID>> extractedClientInformations = jwtTokenValidator.verifyJwtTokenAndReturnClientInformationsIfValid(
                command.getJwtAuthenticationToken());
        return extractedClientInformations.map(
                clientInformations -> new SuccessfulAuthenticationResponse(clientInformations.getFirst(), clientInformations.getSecond()));
    }

}
