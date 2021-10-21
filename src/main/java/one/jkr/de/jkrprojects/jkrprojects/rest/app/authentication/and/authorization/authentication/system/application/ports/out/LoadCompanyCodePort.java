package one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authentication.system.application.ports.out;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCode;

import java.util.Optional;

public interface LoadCompanyCodePort {

    Optional<CompanyCode> getCompanyCode(@NonNull String companyCode);

}
