package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.adapters.out.database.repository;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.adapters.out.database.entity.classes.ApplicationChapterDto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ApplicationChapterRepository extends CrudRepository<ApplicationChapterDto, UUID> {

    Optional<ApplicationChapterDto> getApplicationChapterDtoByApplicationChapterId(@NonNull UUID applicationChapterId);

    Set<ApplicationChapterDto> findApplicationChapterDtosByCompanyCodeId(@NonNull UUID companyCodeId);

    void deleteByApplicationChapterId(@NonNull UUID applicationChapterId);

}
