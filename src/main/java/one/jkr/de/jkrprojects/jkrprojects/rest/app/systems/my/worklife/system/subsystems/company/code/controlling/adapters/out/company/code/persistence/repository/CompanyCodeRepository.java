package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.adapters.out.company.code.persistence.repository;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.adapters.out.company.code.persistence.entity.classes.CompanyCodeDto;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

public interface CompanyCodeRepository extends CrudRepository<CompanyCodeDto, UUID> {

    Optional<CompanyCodeDto> getCompanyCodeDtoByCompanyCodeId(@NonNull UUID companyCodeId);

    Optional<CompanyCodeDto> getCompanyCodeDtoByCompanyCode(@NonNull String companyCode);

    @Transactional
    void removeByCompanyCodeId(@NonNull UUID companyCodeId);

}
