package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.application.ports.in;

import lombok.NonNull;
import lombok.Value;

import java.time.OffsetDateTime;

@Value
public class AddCompanyCodeCommand {

    @NonNull
    String companyCode;

    @NonNull
    OffsetDateTime validUntil;

}
