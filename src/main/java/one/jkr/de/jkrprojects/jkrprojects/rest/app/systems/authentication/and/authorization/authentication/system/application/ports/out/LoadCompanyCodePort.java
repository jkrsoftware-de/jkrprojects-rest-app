package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authentication.system.application.ports.out;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCode;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;

import java.util.Optional;

public interface LoadCompanyCodePort {

    Optional<CompanyCode> getCompanyCode(@NonNull String companyCode);

    Optional<CompanyCode> getCompanyCode(@NonNull CompanyCodeId companyCodeId);

}
