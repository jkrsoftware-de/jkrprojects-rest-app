package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.adapters.out.persistence.employment.contract.offers.entity.data.classes;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "EMPLOYMENT_CONTRACT_OFFERS")
@Value(staticConstructor = "of")
@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class EmploymentContractOfferDto {

    @NonNull
    @Id
    UUID employmentContractOfferId;

    @NonNull
    String nameOfCompany;

    @NonNull
    String companyCodeId;

    int wishSalaryAmount;

    @NonNull
    String wishSalaryCurrency;

    boolean wishSalaryIsNegotiable;

    @NonNull
    OffsetDateTime createdAt;

    @NonNull
    OffsetDateTime lastModified;

}
