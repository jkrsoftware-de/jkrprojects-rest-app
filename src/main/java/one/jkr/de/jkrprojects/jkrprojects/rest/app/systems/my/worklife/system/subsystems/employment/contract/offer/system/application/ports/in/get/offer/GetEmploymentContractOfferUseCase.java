package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.get.offer;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.EmploymentContractOffer;

import java.util.Optional;
import java.util.Set;

public interface GetEmploymentContractOfferUseCase {

    Set<EmploymentContractOffer> listAllOffers();

    Optional<EmploymentContractOffer> getOffer(@NonNull GetEmploymentContractOfferByIdCommand command);

}
