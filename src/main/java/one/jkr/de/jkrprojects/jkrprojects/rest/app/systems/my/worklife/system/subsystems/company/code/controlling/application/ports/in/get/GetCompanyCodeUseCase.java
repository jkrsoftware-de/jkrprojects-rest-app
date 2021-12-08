package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.application.ports.in.get;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCode;

import java.util.Optional;

public interface GetCompanyCodeUseCase {

    Optional<CompanyCode> getCompanyCode(@NonNull GetCompanyCodeEntityViaCompanyCodeIdCommand command);

    Optional<CompanyCode> getCompanyCode(@NonNull GetCompanyCodeEntityViaCompanyCodeCommand command);

}
