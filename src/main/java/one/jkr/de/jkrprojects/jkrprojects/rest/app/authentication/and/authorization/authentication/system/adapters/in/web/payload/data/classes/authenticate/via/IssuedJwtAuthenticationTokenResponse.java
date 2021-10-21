package one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.adapters.in.web.payload.data.classes.authenticate.via;

import lombok.NonNull;
import lombok.Value;

@Value
public class IssuedJwtAuthenticationTokenResponse {

    @NonNull
    String issuedJwtToken;

}
