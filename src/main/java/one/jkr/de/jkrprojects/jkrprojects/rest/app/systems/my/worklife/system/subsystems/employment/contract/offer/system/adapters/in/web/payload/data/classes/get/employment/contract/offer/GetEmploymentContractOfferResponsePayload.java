package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.adapters.in.web.payload.data.classes.get.employment.contract.offer;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.wish.salary.WishSalary;

import java.time.OffsetDateTime;
import java.util.UUID;

@Value(staticConstructor = "of")
public class GetEmploymentContractOfferResponsePayload {

    @NonNull
    UUID offerId;

    @NonNull
    String nameOfCompany;

    @NonNull
    UUID companyCodeId;

    @NonNull
    WishSalary wishSalary;

    @NonNull
    OffsetDateTime createdAt;

}
