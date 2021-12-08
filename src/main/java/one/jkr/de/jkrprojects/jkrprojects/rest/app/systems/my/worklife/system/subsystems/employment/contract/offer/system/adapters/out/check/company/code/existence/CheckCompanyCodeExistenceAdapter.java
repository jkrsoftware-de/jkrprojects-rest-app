package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.adapters.out.check.company.code.existence;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.adapters.in.internal.InternalCompanyCodeAdapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.out.CheckCompanyCodeExistencePort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckCompanyCodeExistenceAdapter implements CheckCompanyCodeExistencePort {

    @NonNull
    private final InternalCompanyCodeAdapter internalCompanyCodeAdapter;

    @Override
    public boolean isExistent(@NonNull CompanyCodeId companyCodeId) {
        return internalCompanyCodeAdapter.getCompanyCode(companyCodeId).isPresent();
    }

}
