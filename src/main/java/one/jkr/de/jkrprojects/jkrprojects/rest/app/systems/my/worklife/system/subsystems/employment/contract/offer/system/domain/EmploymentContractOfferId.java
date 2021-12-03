package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value(staticConstructor = "of")
public class EmploymentContractOfferId {

    @NonNull
    UUID id;

    public static EmploymentContractOfferId ofRandomId() {
        return EmploymentContractOfferId.of(UUID.randomUUID());
    }

}
