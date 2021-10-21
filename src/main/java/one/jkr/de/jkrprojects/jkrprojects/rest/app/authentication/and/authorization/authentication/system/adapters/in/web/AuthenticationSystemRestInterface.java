package one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.adapters.in.web;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.adapters.in.web.payload.data.classes.authenticate.via.IssuedJwtAuthenticationTokenResponse;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.adapters.in.web.payload.data.classes.authenticate.via.company.code.AuthenticateViaCompanyCodeRequest;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.adapters.in.web.payload.data.classes.authenticate.via.system.client.credentials.AuthenticateViaSystemClientCredentialsRequest;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.application.ports.in.AuthenticateViaCompanyCodeCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.application.ports.in.AuthenticateViaSystemClientCredentialsCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.application.ports.in.AuthenticationUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.jwt.JwtAuthenticationToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AuthenticationSystemRestInterface {

    @NonNull
    private final AuthenticationUseCase authenticationUseCase;

    @RequestMapping(value = "/authentication-system/authenticate/by-company-code", method = RequestMethod.POST,
            consumes = "application/vnd.jkrsoftwarede.authentication-system.v1+json",
            produces = "application/vnd.jkrsoftwarede.authentication-system.v1+json")
    public ResponseEntity<?> authenticate(@RequestBody @NonNull AuthenticateViaCompanyCodeRequest payload) {
        Optional<JwtAuthenticationToken> jwtAuthenticationToken = authenticationUseCase.authenticateClient(
                new AuthenticateViaCompanyCodeCommand(payload.getCompanyCode())
        );
        return buildResponseEntityForJwtAuthenticationToken(jwtAuthenticationToken);
    }

    @RequestMapping(value = "/authentication-system/authenticate/by-system-client-credentials", method = RequestMethod.POST,
            consumes = "application/vnd.jkrsoftwarede.authentication-system.v1+json",
            produces = "application/vnd.jkrsoftwarede.authentication-system.v1+json")
    public ResponseEntity<?> authenticate(@RequestBody @NonNull AuthenticateViaSystemClientCredentialsRequest payload) {
        Optional<JwtAuthenticationToken> jwtAuthenticationToken = authenticationUseCase.authenticateClient(
                new AuthenticateViaSystemClientCredentialsCommand(payload.getSystemClientId(), payload.getSystemClientSecret())
        );
        return buildResponseEntityForJwtAuthenticationToken(jwtAuthenticationToken);
    }

    private ResponseEntity<?> buildResponseEntityForJwtAuthenticationToken(Optional<JwtAuthenticationToken> jwtAuthenticationToken) {
        if (jwtAuthenticationToken.isPresent()) {
            return ResponseEntity.ok(
                    new IssuedJwtAuthenticationTokenResponse(jwtAuthenticationToken.get().getJwtToken())
            );
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

}
