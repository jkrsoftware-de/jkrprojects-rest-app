package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.application.ports.out;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCode;

import java.util.Optional;
import java.util.UUID;

public interface CompanyCodePersistencePort {

    Optional<CompanyCode> getCompanyCode(@NonNull UUID companyCodeId);

    Optional<CompanyCode> getCompanyCode(@NonNull String companyCode);

    void save(@NonNull CompanyCode companyCode);

}
