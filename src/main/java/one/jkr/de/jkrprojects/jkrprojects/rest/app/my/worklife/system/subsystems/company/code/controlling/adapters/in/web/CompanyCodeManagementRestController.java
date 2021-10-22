package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.adapters.in.web;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.adapters.in.internal.rest.controllers.InternalAuthorizationSystemAdapterForRestControllers;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.adapters.in.internal.rest.controllers.rest.exceptions.NoAuthorizationRestException;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.adapters.in.web.payload.data.classes.request.CreateCompanyCodeRequestPayload;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.adapters.in.web.payload.data.classes.response.CreateCompanyCodeResponsePayload;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.application.ports.in.AddCompanyCodeCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.application.ports.in.CompanyCodeUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CompanyCodeManagementRestController {

    private static final String LOG_PREFIX = "[Company Code Management REST-Controller]: ";

    @NonNull
    InternalAuthorizationSystemAdapterForRestControllers internalAuthorizationSystemAdapterForRestControllers;

    @NonNull
    private final CompanyCodeUseCase companyCodeUseCase;

    @RequestMapping(value = "/company-code-management/{companyCode}", method = RequestMethod.PUT)
    public CreateCompanyCodeResponsePayload addCompanyCode(@RequestHeader("Authorization") @NonNull String authorizationHeader,
                                                           @PathVariable @NonNull String companyCode,
                                                           @RequestBody @NonNull CreateCompanyCodeRequestPayload payload) throws NoAuthorizationRestException {
        internalAuthorizationSystemAdapterForRestControllers.checkSystemClientAuthorization(authorizationHeader);

        log.info(LOG_PREFIX + "Create Company Code: \"{}\".", payload);
        return new CreateCompanyCodeResponsePayload(
                companyCodeUseCase.addCodeForCompany(
                        new AddCompanyCodeCommand(companyCode, payload.getValidUntil())
                ).getCompanyCodeId().getId()
        );
    }

}
