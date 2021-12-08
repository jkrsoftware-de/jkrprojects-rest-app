package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.out.application.chapter.persistence.repository;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.out.application.chapter.persistence.entity.classes.ApplicationChapterDto;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ApplicationChapterRepository extends CrudRepository<ApplicationChapterDto, UUID> {

    Optional<ApplicationChapterDto> getApplicationChapterDtoByApplicationChapterId(@NonNull UUID applicationChapterId);

    Set<ApplicationChapterDto> findApplicationChapterDtosByCompanyCodeId(@NonNull UUID companyCodeId);

    @Transactional
    void removeByApplicationChapterId(@NonNull UUID applicationChapterId);

}
