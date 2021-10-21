package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.adapters.in.web.payload.data.classes.response;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class CreateCompanyCodeResponsePayload {

    @NonNull
    UUID companyCodeId;

}
