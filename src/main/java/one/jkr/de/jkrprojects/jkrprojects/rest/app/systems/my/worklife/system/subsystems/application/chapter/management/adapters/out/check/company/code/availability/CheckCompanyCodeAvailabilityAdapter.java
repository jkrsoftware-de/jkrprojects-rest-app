package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.out.check.company.code.availability;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.out.CheckCompanyCodeAvailabilityPort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.adapters.in.internal.InternalCompanyCodeAdapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckCompanyCodeAvailabilityAdapter implements CheckCompanyCodeAvailabilityPort {

    @NonNull
    private final InternalCompanyCodeAdapter internalCompanyCodeAdapter;

    @Override
    public boolean doesCompanyCodeExists(@NonNull CompanyCodeId companyCodeId) {
        return internalCompanyCodeAdapter.getCompanyCode(companyCodeId).isPresent();
    }

}
