package one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.application.ports.in;

import lombok.NonNull;
import lombok.Value;

@Value
public class AuthenticateViaCompanyCodeCommand {

    @NonNull
    String companyCode;

}
