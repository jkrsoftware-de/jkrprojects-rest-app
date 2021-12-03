package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.create.offer.CreateEmploymentContractOfferCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.create.offer.CreateEmploymentContractOfferUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.get.offer.GetEmploymentContractOfferByIdCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.get.offer.GetEmploymentContractOfferUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.out.EmploymentContractOfferPersistencePort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.EmploymentContractOffer;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.EmploymentContractOfferId;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class EmploymentContractOfferService implements CreateEmploymentContractOfferUseCase, GetEmploymentContractOfferUseCase {

    @NonNull
    private final EmploymentContractOfferPersistencePort employmentContractOfferPersistencePort;

    @NonNull
    private final Clock clock;

    @Override
    public EmploymentContractOffer createOffer(@NonNull CreateEmploymentContractOfferCommand command) {
        EmploymentContractOffer newOffer = EmploymentContractOffer.of(
                EmploymentContractOfferId.ofRandomId(),
                command.getNameOfCompany(), command.getCompanyCode(), command.getWishSalary(),
                OffsetDateTime.now(clock), OffsetDateTime.now(clock)
        );
        employmentContractOfferPersistencePort.save(newOffer);
        return newOffer;
    }

    @Override
    public Set<EmploymentContractOffer> listAllOffers() {
        return employmentContractOfferPersistencePort.listOffers(Pageable.unpaged());
    }

    @Override
    public Optional<EmploymentContractOffer> getOffer(@NonNull GetEmploymentContractOfferByIdCommand command) {
        return employmentContractOfferPersistencePort.getById(command.getEmploymentContractOfferId());
    }
}
