package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.adapters.out.persistence.database;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.adapters.out.persistence.database.entity.classes.CompanyCodeDto;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.adapters.out.persistence.database.repository.CompanyCodeRepository;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.application.ports.out.CompanyCodePersistencePort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCode;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CompanyCodeDatabaseController implements CompanyCodePersistencePort {

    @NonNull
    private final CompanyCodeRepository companyCodeRepository;

    @NonNull
    private final Clock clock;

    @Override
    public Optional<CompanyCode> getCompanyCode(@NonNull UUID companyCodeId) {
        return companyCodeRepository.getCompanyCodeDtoByCompanyCodeId(companyCodeId).map(this::mapToDomainEntityObject);
    }

    @Override
    public Optional<CompanyCode> getCompanyCode(@NonNull String companyCode) {
        return companyCodeRepository.getCompanyCodeDtoByCompanyCode(companyCode).map(this::mapToDomainEntityObject);
    }

    @Override
    public void save(@NonNull CompanyCode companyCode) {
        companyCodeRepository.save(mapToDatabaseEntityObject(companyCode));
    }

    private CompanyCode mapToDomainEntityObject(CompanyCodeDto companyCodeDto) {
        return new CompanyCode(
                new CompanyCodeId(companyCodeDto.getCompanyCodeId()),
                companyCodeDto.getCompanyCode(),
                companyCodeDto.getCreatedAt(),
                companyCodeDto.getLastModified()
        );
    }

    private CompanyCodeDto mapToDatabaseEntityObject(CompanyCode companyCode) {
        return new CompanyCodeDto(
                companyCode.getCompanyCodeId().getId(),
                companyCode.getCompanyCode(),
                companyCode.getCreatedAt(),
                OffsetDateTime.now(clock)
        );
    }
}
