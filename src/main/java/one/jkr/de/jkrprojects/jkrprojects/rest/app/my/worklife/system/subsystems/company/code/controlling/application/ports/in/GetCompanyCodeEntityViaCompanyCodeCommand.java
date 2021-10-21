package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.application.ports.in;

import lombok.NonNull;
import lombok.Value;

@Value
public class GetCompanyCodeEntityViaCompanyCodeCommand {

    @NonNull
    String companyCode;

}
