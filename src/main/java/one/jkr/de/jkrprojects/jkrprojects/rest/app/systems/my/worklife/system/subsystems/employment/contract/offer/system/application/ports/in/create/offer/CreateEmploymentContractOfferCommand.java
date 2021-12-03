package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.create.offer;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.wish.salary.WishSalary;

@Value(staticConstructor = "of")
public class CreateEmploymentContractOfferCommand {

    @NonNull
    String nameOfCompany;

    @NonNull
    String companyCode;

    @NonNull
    WishSalary wishSalary;

}
