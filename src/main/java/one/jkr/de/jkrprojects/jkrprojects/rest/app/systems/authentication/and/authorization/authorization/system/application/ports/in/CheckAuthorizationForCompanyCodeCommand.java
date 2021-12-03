package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authorization.system.application.ports.in;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.domain.jwt.JwtAuthenticationToken;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;

@Value
public class CheckAuthorizationForCompanyCodeCommand {

    @NonNull
    JwtAuthenticationToken jwtAuthenticationToken;

    @NonNull
    CompanyCodeId companyCodeId;

}
