package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.application.ports.out;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCode;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;

import java.util.Optional;
import java.util.UUID;

public interface CompanyCodePersistencePort {

    Optional<CompanyCode> getCompanyCode(@NonNull UUID companyCodeId);

    Optional<CompanyCode> getCompanyCode(@NonNull String companyCode);

    void save(@NonNull CompanyCode companyCode);

    boolean remove(@NonNull CompanyCodeId companyCodeId);

}
