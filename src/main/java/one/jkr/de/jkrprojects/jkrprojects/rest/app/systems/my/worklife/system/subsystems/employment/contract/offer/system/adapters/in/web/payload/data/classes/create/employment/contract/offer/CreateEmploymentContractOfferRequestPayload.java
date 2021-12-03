package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.adapters.in.web.payload.data.classes.create.employment.contract.offer;

import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class CreateEmploymentContractOfferRequestPayload {

    @NonNull
    String nameOfCompany;

    @NonNull
    String companyCode;

    int wishSalaryAmount;

    @NonNull
    String currencyOfWishSalary;

    boolean isWishSalaryNegotiable;

}
