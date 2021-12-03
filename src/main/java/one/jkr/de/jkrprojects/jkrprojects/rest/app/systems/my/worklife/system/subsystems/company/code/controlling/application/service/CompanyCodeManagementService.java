package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.application.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.application.ports.in.AddCompanyCodeCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.application.ports.in.CompanyCodeUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.application.ports.in.GetCompanyCodeEntityViaCompanyCodeCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.application.ports.in.GetCompanyCodeEntityViaCompanyCodeIdCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.application.ports.out.CompanyCodePersistencePort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCode;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class CompanyCodeManagementService implements CompanyCodeUseCase {

    @NonNull
    private static final String LOG_PREFIX = "[Company Code Management Service]: ";

    @NonNull
    private final CompanyCodePersistencePort persistencePort;

    @NonNull
    private final Clock clock;

    @Override
    public Optional<CompanyCode> getCompanyCode(@NonNull GetCompanyCodeEntityViaCompanyCodeIdCommand command) {
        return persistencePort.getCompanyCode(command.getCompanyCodeId().getId());
    }

    @Override
    public Optional<CompanyCode> getCompanyCode(@NonNull GetCompanyCodeEntityViaCompanyCodeCommand command) {
        return persistencePort.getCompanyCode(command.getCompanyCode());
    }

    @Override
    public CompanyCode addCodeForCompany(@NonNull AddCompanyCodeCommand command) {
        log.info(LOG_PREFIX + "Add Company Code: \"{}\".", command);

        Optional<CompanyCode> companyCode = persistencePort.getCompanyCode(command.getCompanyCode());
        if (companyCode.isPresent()) {
            log.info(LOG_PREFIX + "Company Code \"{}\" is already created.", command.getCompanyCode());
            return companyCode.get();
        }

        CompanyCode newCompanyCode = new CompanyCode(
                new CompanyCodeId(UUID.randomUUID()), command.getCompanyCode(),
                OffsetDateTime.now(clock), OffsetDateTime.now(clock)
        );
        persistencePort.save(newCompanyCode);
        return newCompanyCode;
    }

}
