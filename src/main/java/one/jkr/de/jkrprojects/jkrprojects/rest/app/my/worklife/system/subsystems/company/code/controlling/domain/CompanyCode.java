package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.domain;

import lombok.NonNull;
import lombok.Value;

import java.time.OffsetDateTime;

@Value
public class CompanyCode {

    @NonNull
    CompanyCodeId companyCodeId;

    @NonNull
    String companyCode;

    @NonNull
    OffsetDateTime createdAt;

    @NonNull
    OffsetDateTime lastModified;

}
