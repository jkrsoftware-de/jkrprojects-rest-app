package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.out;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;

public interface CheckCompanyCodeExistencePort {

    boolean isExistent(@NonNull CompanyCodeId companyCodeId);

}
