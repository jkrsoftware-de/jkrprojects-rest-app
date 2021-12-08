package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.adapters.in.internal;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.application.ports.in.get.GetCompanyCodeEntityViaCompanyCodeCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.application.ports.in.get.GetCompanyCodeEntityViaCompanyCodeIdCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.application.ports.in.get.GetCompanyCodeUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.application.ports.in.remove.RemoveCompanyCodeCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.application.ports.in.remove.RemoveCompanyCodeUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCode;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class InternalCompanyCodeAdapter {

    @NonNull
    private final GetCompanyCodeUseCase getCompanyCodeUseCase;

    @NonNull
    private final RemoveCompanyCodeUseCase removeCompanyCodeUseCase;

    public Optional<CompanyCode> getCompanyCode(@NonNull CompanyCodeId companyCodeId) {
        return getCompanyCodeUseCase.getCompanyCode(
                new GetCompanyCodeEntityViaCompanyCodeIdCommand(companyCodeId)
        );
    }

    public Optional<CompanyCode> getCompanyCode(@NonNull String companyCode) {
        return getCompanyCodeUseCase.getCompanyCode(
                new GetCompanyCodeEntityViaCompanyCodeCommand(companyCode)
        );
    }

    public boolean removeCompanyCode(@NonNull CompanyCodeId companyCodeId) {
        return removeCompanyCodeUseCase.remove(
                new RemoveCompanyCodeCommand(companyCodeId)
        );
    }

}
