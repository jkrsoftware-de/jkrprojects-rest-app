package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.create.offer.CreateEmploymentContractOfferCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.create.offer.CreateEmploymentContractOfferUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.delete.offer.DeleteEmploymentContractOfferCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.delete.offer.DeleteEmploymentContractOfferUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.get.offer.GetEmploymentContractOfferByIdCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.get.offer.GetEmploymentContractOfferUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.out.DeleteCompanyCodePort;
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
public class EmploymentContractOfferService implements GetEmploymentContractOfferUseCase, CreateEmploymentContractOfferUseCase,
        DeleteEmploymentContractOfferUseCase {

    @NonNull
    private final EmploymentContractOfferPersistencePort employmentContractOfferPersistencePort;

    @NonNull
    private final DeleteCompanyCodePort deleteCompanyCodePort;

    @NonNull
    private final Clock clock;

    @Override
    public Set<EmploymentContractOffer> listAllOffers() {
        return employmentContractOfferPersistencePort.listOffers(Pageable.unpaged());
    }

    @Override
    public Optional<EmploymentContractOffer> getOffer(@NonNull GetEmploymentContractOfferByIdCommand command) {
        return employmentContractOfferPersistencePort.getById(command.getEmploymentContractOfferId());
    }

    @Override
    public EmploymentContractOffer createOffer(@NonNull CreateEmploymentContractOfferCommand command) {
        EmploymentContractOffer newOffer = EmploymentContractOffer.of(
                EmploymentContractOfferId.ofRandomId(),
                command.getNameOfCompany(), command.getCompanyCodeId(), command.getWishSalary(),
                OffsetDateTime.now(clock), OffsetDateTime.now(clock)
        );
        employmentContractOfferPersistencePort.save(newOffer);
        return newOffer;
    }

    @Override
    public boolean deleteOffer(@NonNull DeleteEmploymentContractOfferCommand command) {
        Optional<EmploymentContractOffer> employmentContractOffer = employmentContractOfferPersistencePort.getById(
                command.getEmploymentContractOfferToDelete());

        if (employmentContractOffer.isPresent()) {
            deleteCompanyCodePort.deleteCompanyCode(employmentContractOffer.get().getCompanyCodeId());
            return employmentContractOfferPersistencePort.delete(command.getEmploymentContractOfferToDelete());
        }
        return false;
    }
}
