package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.create.offer;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.EmploymentContractOffer;

public interface CreateEmploymentContractOfferUseCase {

    EmploymentContractOffer createOffer(@NonNull CreateEmploymentContractOfferCommand command);

}
