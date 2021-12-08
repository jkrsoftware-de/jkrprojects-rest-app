package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.delete.offer;

import lombok.NonNull;

public interface DeleteEmploymentContractOfferUseCase {

    boolean deleteOffer(@NonNull DeleteEmploymentContractOfferCommand command);

}
