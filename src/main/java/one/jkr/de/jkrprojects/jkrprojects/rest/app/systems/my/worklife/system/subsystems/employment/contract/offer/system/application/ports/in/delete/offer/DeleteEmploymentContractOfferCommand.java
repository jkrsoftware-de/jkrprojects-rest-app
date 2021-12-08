package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.delete.offer;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.EmploymentContractOfferId;

@Value
public class DeleteEmploymentContractOfferCommand {

    @NonNull
    EmploymentContractOfferId employmentContractOfferToDelete;

}
