package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.adapters.out.persistence.employment.contract.offers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.adapters.out.persistence.employment.contract.offers.entity.data.classes.EmploymentContractOfferDto;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.adapters.out.persistence.employment.contract.offers.repository.EmploymentContractOfferRepository;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.out.EmploymentContractOfferPersistencePort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.EmploymentContractOffer;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.EmploymentContractOfferId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.wish.salary.Currency;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.wish.salary.WishSalary;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmploymentContractOfferDatabaseController implements EmploymentContractOfferPersistencePort {

    @NonNull
    private final EmploymentContractOfferRepository employmentContractOfferRepository;

    @Override
    public Set<EmploymentContractOffer> listOffers(@NonNull Pageable pageable) {
        return employmentContractOfferRepository.findAll(pageable)
                .stream().map(this::mapToDomainEntityObject).collect(Collectors.toSet());
    }

    @Override
    public Optional<EmploymentContractOffer> getById(@NonNull EmploymentContractOfferId employmentContractOfferId) {
        return employmentContractOfferRepository.findByEmploymentContractOfferId(employmentContractOfferId.getId())
                .map(this::mapToDomainEntityObject);
    }

    @Override
    public void save(@NonNull EmploymentContractOffer employmentContractOffer) {
        employmentContractOfferRepository.save(mapToDatabaseEntityObject(employmentContractOffer));
    }

    private EmploymentContractOffer mapToDomainEntityObject(EmploymentContractOfferDto dto) {
        return EmploymentContractOffer.of(
                EmploymentContractOfferId.of(dto.getEmploymentContractOfferId()),
                dto.getNameOfCompany(),
                dto.getCompanyCode(),
                WishSalary.of(
                        dto.getWishSalaryAmount(),
                        Currency.valueOf(dto.getWishSalaryCurrency()),
                        dto.isWishSalaryIsNegotiable()
                ),
                dto.getCreatedAt(),
                dto.getLastModified()
        );
    }

    private EmploymentContractOfferDto mapToDatabaseEntityObject(EmploymentContractOffer deo) {
        return new EmploymentContractOfferDto(
                deo.getOfferId().getId(),
                deo.getNameOfCompany(),
                deo.getCompanyCode(),
                deo.getWishSalary().getAmount(),
                deo.getWishSalary().getCurrency().name(),
                deo.getWishSalary().isNegotiable(),
                deo.getCreatedAt(),
                deo.getLastModified()
        );
    }

}
