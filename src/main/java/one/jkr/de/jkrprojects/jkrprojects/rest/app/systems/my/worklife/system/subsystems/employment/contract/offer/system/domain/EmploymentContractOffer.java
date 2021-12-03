package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.wish.salary.WishSalary;

import java.time.OffsetDateTime;

@Value(staticConstructor = "of")
public class EmploymentContractOffer {

    @NonNull
    EmploymentContractOfferId offerId;

    @NonNull
    String nameOfCompany;

    @NonNull
    String companyCode;

    @NonNull
    WishSalary wishSalary;

    @NonNull
    OffsetDateTime createdAt;

    @NonNull
    OffsetDateTime lastModified;

}
