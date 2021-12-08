package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.adapters.in.automatic.delete;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.delete.offer.DeleteEmploymentContractOfferCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.delete.offer.DeleteEmploymentContractOfferUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.get.offer.GetEmploymentContractOfferUseCase;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

@Component
@RequiredArgsConstructor
public class AutomaticEmploymentContractOfferDeleter {

    private static final Duration EXPIRATION_DURATION = Duration.of(30, ChronoUnit.DAYS);

    @NonNull
    private final GetEmploymentContractOfferUseCase getEmploymentContractOfferUseCase;

    @NonNull
    private final DeleteEmploymentContractOfferUseCase deleteEmploymentContractOfferUseCase;

    @NonNull
    private final Clock clock;

    @Scheduled(cron = "0 0 6 * * ?")
    private void deleteExpiredEmploymentContractOffers() {
        getEmploymentContractOfferUseCase.listAllOffers().forEach(employmentContractOffer -> {
                    if (employmentContractOffer.getCreatedAt().plus(EXPIRATION_DURATION).isBefore(OffsetDateTime.now(clock))) {
                        deleteEmploymentContractOfferUseCase.deleteOffer(
                                new DeleteEmploymentContractOfferCommand(employmentContractOffer.getOfferId())
                        );
                    }
                }
        );
    }

}
