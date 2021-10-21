package one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.application.utils.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.jwt.JwtAuthenticationToken;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.domain.jwt.subjects.TypeOfClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class JwtTokenValidator {

    @NonNull
    private final Clock clock;

    @NonNull
    private final ObjectMapper objectMapper;

    @Value("${authentication-system.jwt-tokens.signing-secret}")
    private String jwtTokenSigningSecret;

    public Optional<Pair<TypeOfClient, UUID>> verifyJwtTokenAndReturnClientInformationsIfValid(
            @NonNull JwtAuthenticationToken jwtAuthenticationToken) {
        if (isJwtAuthenticationTokenValid(jwtAuthenticationToken)) {
            return Optional.of(Pair.of(
                    getClientTypeOfJwtAuthenticationToken(jwtAuthenticationToken),
                    getSubjectOfJwtAuthenticationToken(jwtAuthenticationToken))
            );
        } else {
            return Optional.empty();
        }
    }

    private boolean isJwtAuthenticationTokenValid(JwtAuthenticationToken jwtAuthenticationToken) {
        return getExpirationDateOfJwtAuthenticationToken(jwtAuthenticationToken).after(Date.from(Instant.now(clock)));
    }

    private Date getExpirationDateOfJwtAuthenticationToken(JwtAuthenticationToken jwtAuthenticationToken) {
        return getClaimOfJwtAuthenticationToken(jwtAuthenticationToken, Claims::getExpiration);
    }

    private UUID getSubjectOfJwtAuthenticationToken(JwtAuthenticationToken jwtAuthenticationToken) {
        return UUID.fromString(getClaimOfJwtAuthenticationToken(jwtAuthenticationToken, Claims::getSubject));
    }

    private TypeOfClient getClientTypeOfJwtAuthenticationToken(JwtAuthenticationToken jwtAuthenticationToken) {
        return TypeOfClient.valueOf(
                getClaimOfJwtAuthenticationToken(jwtAuthenticationToken, claims -> claims.get("client-type", String.class)));
    }

    private <T> T getClaimOfJwtAuthenticationToken(JwtAuthenticationToken jwtAuthenticationToken, Function<Claims, T> claimsResolver) {
        Claims allClaimsOfJwtToken = Jwts.parser()
                .setSigningKey(jwtTokenSigningSecret)
                .parseClaimsJws(jwtAuthenticationToken.getJwtToken())
                .getBody();
        return claimsResolver.apply(allClaimsOfJwtToken);
    }

}
