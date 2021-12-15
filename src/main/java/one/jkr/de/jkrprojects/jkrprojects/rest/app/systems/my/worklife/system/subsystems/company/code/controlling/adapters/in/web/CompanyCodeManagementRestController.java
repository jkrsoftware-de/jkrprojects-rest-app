package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.adapters.in.web;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authorization.system.adapters.in.internal.rest.controllers.InternalAuthorizationSystemAdapterForRestControllers;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authorization.system.adapters.in.internal.rest.controllers.rest.exceptions.NoAuthorizationRestException;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.adapters.in.web.payload.data.classes.request.CreateCompanyCodeRequestPayload;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.adapters.in.web.payload.data.classes.response.CreateCompanyCodeResponsePayload;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.application.ports.in.create.AddCompanyCodeCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.application.ports.in.create.AddCompanyCodeUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CompanyCodeManagementRestController {

    private static final String LOG_PREFIX = "[Company Code Management REST-Controller]: ";

    @NonNull
    private final InternalAuthorizationSystemAdapterForRestControllers internalAuthorizationSystemAdapterForRestControllers;

    @NonNull
    private final AddCompanyCodeUseCase addCompanyCodeUseCase;

    @RequestMapping(value = "/company-code-management/{companyCode}", method = RequestMethod.PUT,
            consumes = "application/vnd.jkrsoftwarede.my-worklife.company-code-controlling-system.v1+json",
            produces = "application/vnd.jkrsoftwarede.my-worklife.company-code-controlling-system.v1+json")
    public CreateCompanyCodeResponsePayload addCompanyCode(@RequestHeader("Authorization") @NonNull String authorizationHeader,
                                                           @PathVariable @NonNull String companyCode,
                                                           @RequestBody @NonNull CreateCompanyCodeRequestPayload payload)
            throws NoAuthorizationRestException {
        internalAuthorizationSystemAdapterForRestControllers.checkSystemClientAuthorization(authorizationHeader);

        log.info(LOG_PREFIX + "Create Company Code: \"{}\".", payload);
        return new CreateCompanyCodeResponsePayload(
                addCompanyCodeUseCase.addCodeForCompany(
                        new AddCompanyCodeCommand(companyCode, payload.getValidUntil())
                ).getCompanyCodeId().getId()
        );
    }

}
