package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.out;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.EmploymentContractOffer;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.EmploymentContractOfferId;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.Set;

public interface EmploymentContractOfferPersistencePort {

    Set<EmploymentContractOffer> listOffers(@NonNull Pageable pageable);

    Optional<EmploymentContractOffer> getById(@NonNull EmploymentContractOfferId employmentContractOfferId);

    void save(@NonNull EmploymentContractOffer employmentContractOffer);

}
