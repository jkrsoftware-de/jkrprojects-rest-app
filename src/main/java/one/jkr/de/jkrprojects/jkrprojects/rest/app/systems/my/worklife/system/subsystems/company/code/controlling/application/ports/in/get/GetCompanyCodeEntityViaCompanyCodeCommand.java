package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.application.ports.in.get;

import lombok.NonNull;
import lombok.Value;

@Value
public class GetCompanyCodeEntityViaCompanyCodeCommand {

    @NonNull
    String companyCode;

}
