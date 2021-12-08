package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.adapters.out.persistence.employment.contract.offers.repository;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.adapters.out.persistence.employment.contract.offers.entity.data.classes.EmploymentContractOfferDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmploymentContractOfferRepository extends CrudRepository<EmploymentContractOfferDto, UUID> {

    List<EmploymentContractOfferDto> findAll(@NonNull Pageable pageable);

    Optional<EmploymentContractOfferDto> findByEmploymentContractOfferId(@NonNull UUID employmentContractOfferId);

    @Transactional
    void removeByEmploymentContractOfferId(@NonNull UUID employmentContractOfferId);

}
