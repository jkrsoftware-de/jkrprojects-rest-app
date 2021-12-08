package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.adapters.in.web;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authorization.system.adapters.in.internal.rest.controllers.InternalAuthorizationSystemAdapterForRestControllers;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authorization.system.adapters.in.internal.rest.controllers.rest.exceptions.NoAuthorizationRestException;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.adapters.in.web.payload.data.classes.create.employment.contract.offer.CreateEmploymentContractOfferRequestPayload;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.adapters.in.web.payload.data.classes.create.employment.contract.offer.CreateEmploymentContractOfferResponsePayload;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.adapters.in.web.payload.data.classes.get.employment.contract.offer.GetEmploymentContractOfferResponsePayload;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.create.offer.CreateEmploymentContractOfferCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.create.offer.CreateEmploymentContractOfferUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.delete.offer.DeleteEmploymentContractOfferCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.delete.offer.DeleteEmploymentContractOfferUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.get.offer.GetEmploymentContractOfferByIdCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.in.get.offer.GetEmploymentContractOfferUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.EmploymentContractOffer;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.EmploymentContractOfferId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.wish.salary.Currency;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.wish.salary.WishSalary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class EmploymentContractOfferRestController {

    @NonNull
    private final InternalAuthorizationSystemAdapterForRestControllers internalAuthorizationSystemAdapterForRestControllers;

    @NonNull
    private final GetEmploymentContractOfferUseCase getEmploymentContractOfferUseCase;

    @NonNull
    private final CreateEmploymentContractOfferUseCase createEmploymentContractOfferUseCase;

    @NonNull
    private final DeleteEmploymentContractOfferUseCase deleteEmploymentContractOfferUseCase;

    @RequestMapping(value = "/employment-contract-offers", method = RequestMethod.POST)
    public ResponseEntity<CreateEmploymentContractOfferResponsePayload> createEmploymentContractOffer(
            @RequestHeader("Authorization") @NonNull String authorizationHeader,
            @RequestBody @NonNull CreateEmploymentContractOfferRequestPayload payload) throws NoAuthorizationRestException {
        internalAuthorizationSystemAdapterForRestControllers.checkSystemClientAuthorization(authorizationHeader);

        EmploymentContractOffer createdOffer = createEmploymentContractOfferUseCase.createOffer(
                CreateEmploymentContractOfferCommand.of(
                        payload.getNameOfCompany(), new CompanyCodeId(payload.getCompanyCodeId()),
                        WishSalary.of(
                                payload.getWishSalaryAmount(), Currency.valueOf(payload.getCurrencyOfWishSalary()),
                                payload.isWishSalaryNegotiable()
                        )
                )
        );
        return ResponseEntity.ok(CreateEmploymentContractOfferResponsePayload.of(createdOffer.getOfferId().getId()));
    }

    @RequestMapping(value = "/employment-contract-offers/by-id/{employmentContractOfferId}", method = RequestMethod.GET)
    public ResponseEntity<?> getEmploymentContractOffer(@PathVariable @NonNull UUID employmentContractOfferId) {
        Optional<EmploymentContractOffer> employmentContractOffer = getEmploymentContractOfferUseCase.getOffer(
                GetEmploymentContractOfferByIdCommand.of(EmploymentContractOfferId.of(employmentContractOfferId))
        );

        if (employmentContractOffer.isPresent()) {
            EmploymentContractOffer offer = employmentContractOffer.get();
            return ResponseEntity.ok(
                    GetEmploymentContractOfferResponsePayload.of(
                            offer.getOfferId().getId(),
                            offer.getNameOfCompany(),
                            offer.getCompanyCodeId().getId(),
                            offer.getWishSalary(),
                            offer.getCreatedAt()
                    )
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/employment-contract-offers/by-id/{employmentContractOfferId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmploymentContractOffer(@PathVariable @NonNull UUID employmentContractOfferId) {
        boolean deleted = deleteEmploymentContractOfferUseCase.deleteOffer(
                new DeleteEmploymentContractOfferCommand(EmploymentContractOfferId.of(employmentContractOfferId))
        );

        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
