package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.adapters.in.internal;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.application.ports.in.CompanyCodeUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.application.ports.in.GetCompanyCodeEntityViaCompanyCodeCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.application.ports.in.GetCompanyCodeEntityViaCompanyCodeIdCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCode;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class InternalCompanyCodeAdapter {

    @NonNull
    private final CompanyCodeUseCase companyCodeUseCase;

    @NonNull
    public Optional<CompanyCode> getCompanyCode(@NonNull CompanyCodeId companyCodeId) {
        return companyCodeUseCase.getCompanyCode(
                new GetCompanyCodeEntityViaCompanyCodeIdCommand(companyCodeId)
        );
    }

    @NonNull
    public Optional<CompanyCode> getCompanyCode(@NonNull String companyCode) {
        return companyCodeUseCase.getCompanyCode(
                new GetCompanyCodeEntityViaCompanyCodeCommand(companyCode)
        );
    }

}
