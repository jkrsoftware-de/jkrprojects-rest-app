package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authorization.system.adapters.in.internal.rest.controllers.rest.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@NoArgsConstructor
@ResponseStatus(code = HttpStatus.UNAUTHORIZED,
        reason = "Your provided Authorization-Header-Content is not a valid JWT Authorization-Token.")
public class JwtTokenMalformedRestException extends IOException {

}
