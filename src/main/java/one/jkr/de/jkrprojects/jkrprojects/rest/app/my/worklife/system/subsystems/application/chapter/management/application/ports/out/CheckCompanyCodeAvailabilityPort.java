package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.application.ports.out;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;

public interface CheckCompanyCodeAvailabilityPort {

    boolean doesCompanyCodeExists(@NonNull CompanyCodeId companyCodeId);

}
