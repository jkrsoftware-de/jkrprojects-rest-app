package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.adapters.in.web.payload.data.classes.create.employment.contract.offer;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value(staticConstructor = "of")
public class CreateEmploymentContractOfferResponsePayload {

    @NonNull
    UUID newEmploymentContractOffer;

}
