package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.out.application.chapter.persistence;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.out.application.chapter.persistence.entity.classes.ApplicationChapterDto;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.out.application.chapter.persistence.repository.ApplicationChapterRepository;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.out.ApplicationChapterPersistencePort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapterId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ApplicationChapterDatabaseController implements ApplicationChapterPersistencePort {

    @NonNull
    private final ApplicationChapterRepository repository;

    @Override
    public Optional<ApplicationChapter> getApplicationChapter(@NonNull ApplicationChapterId applicationChapterId) {
        return repository.getApplicationChapterDtoByApplicationChapterId(applicationChapterId.getId()).map(this::mapToDomainEntityObject);
    }

    @Override
    public Set<ApplicationChapter> getApplicationChapters(@NonNull CompanyCodeId companyCodeId) {
        return repository.findApplicationChapterDtosByCompanyCodeId(companyCodeId.getId()).stream().map(this::mapToDomainEntityObject)
                .collect(Collectors.toSet());
    }

    @Override
    public void save(@NonNull ApplicationChapter applicationChapter) {
        repository.save(mapToDatabaseEntityObject(applicationChapter));
    }

    @Override
    public boolean remove(@NonNull ApplicationChapterId applicationChapterId) {
        if (repository.existsById(applicationChapterId.getId())) {
            repository.removeByApplicationChapterId(applicationChapterId.getId());
            return true;
        }
        return false;
    }

    private ApplicationChapter mapToDomainEntityObject(ApplicationChapterDto applicationChapterDto) {
        return new ApplicationChapter(
                new ApplicationChapterId(applicationChapterDto.getApplicationChapterId()),
                new CompanyCodeId(applicationChapterDto.getCompanyCodeId()),
                applicationChapterDto.getApplicationChapterName(),
                applicationChapterDto.getPredefinedOrderNumber(),
                applicationChapterDto.getCreatedAt(),
                applicationChapterDto.getLastModified()
        );
    }

    private ApplicationChapterDto mapToDatabaseEntityObject(ApplicationChapter applicationChapter) {
        return new ApplicationChapterDto(
                applicationChapter.getApplicationChapterId().getId(),
                applicationChapter.getCompanyCodeId().getId(),
                applicationChapter.getApplicationChapterName(),
                applicationChapter.getPredefinedOrderNumber(),
                applicationChapter.getCreatedAt(),
                applicationChapter.getLastModified()
        );
    }

}
