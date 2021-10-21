package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.adapters.out.persistence.database.repository;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.adapters.out.persistence.database.entity.classes.CompanyCodeDto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyCodeRepository extends CrudRepository<CompanyCodeDto, UUID> {

    Optional<CompanyCodeDto> getCompanyCodeDtoByCompanyCodeId(@NonNull UUID companyCodeId);

    Optional<CompanyCodeDto> getCompanyCodeDtoByCompanyCode(@NonNull String companyCode);

}