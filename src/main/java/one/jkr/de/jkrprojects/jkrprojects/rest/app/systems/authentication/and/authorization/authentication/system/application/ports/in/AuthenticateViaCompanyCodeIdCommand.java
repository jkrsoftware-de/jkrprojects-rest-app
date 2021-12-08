package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.application.ports.in;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;

@Value
public class AuthenticateViaCompanyCodeIdCommand {

    @NonNull
    CompanyCodeId companyCodeId;

}
