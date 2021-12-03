package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.create.offer;

import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.EmploymentContractOffer;

import javax.annotation.Nonnull;

public interface CreateEmploymentContractOfferUseCase {

    EmploymentContractOffer createOffer(@Nonnull CreateEmploymentContractOfferCommand command);

}
