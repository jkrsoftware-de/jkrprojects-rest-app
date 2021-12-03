package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.application.utils.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.jwt.JwtAuthenticationToken;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.jwt.subjects.JwtTokenSubject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtTokenIssuer implements Serializable {

    @NonNull
    private final ObjectMapper objectMapper;

    @NonNull
    private final Clock clock;

    @Value("${authentication-system.jwt-tokens.signing-secret}")
    private String jwtTokenSigningSecret;

    @Value("${authentication-system.jwt-tokens.lifetime}")
    private long jwtTokenLifetime;

    @SneakyThrows
    public JwtAuthenticationToken issueToken(@NonNull JwtTokenSubject jwtTokenSubject) {
        HashMap<String, Object> jwtTokenHeaders = new HashMap<>();
        jwtTokenHeaders.put("client-type", jwtTokenSubject.getTypeOfClient());

        return new JwtAuthenticationToken(generateJwtToken(jwtTokenHeaders, jwtTokenSubject.getClientIdentifier().toString()));
    }

    private String generateJwtToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(Date.from(Instant.now(clock)))
                .setExpiration(Date.from(Instant.now(clock).plus(Duration.ofMillis(jwtTokenLifetime))))
                .signWith(SignatureAlgorithm.HS512, jwtTokenSigningSecret)
                .compact();
    }

}
