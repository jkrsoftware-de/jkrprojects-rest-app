package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.adapters.out.load.company.code;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.application.ports.out.LoadCompanyCodePort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.adapters.in.internal.InternalCompanyCodeAdapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCode;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LoadCompanyCodeAdapter implements LoadCompanyCodePort {

    @NonNull
    private final InternalCompanyCodeAdapter internalCompanyCodeAdapter;

    @Override
    public Optional<CompanyCode> getCompanyCode(@NonNull String companyCode) {
        return internalCompanyCodeAdapter.getCompanyCode(companyCode);
    }

    @Override
    public Optional<CompanyCode> getCompanyCode(@NonNull CompanyCodeId companyCodeId) {
        return internalCompanyCodeAdapter.getCompanyCode(companyCodeId);
    }

}
