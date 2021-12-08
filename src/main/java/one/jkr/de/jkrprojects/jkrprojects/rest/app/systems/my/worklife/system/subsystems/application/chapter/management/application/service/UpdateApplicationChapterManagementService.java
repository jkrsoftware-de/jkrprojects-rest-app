package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.update.UpdateApplicationChapterUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.update.UpdatePredefinedOrderNumberOfApplicationChapterCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.out.ApplicationChapterPersistencePort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapter;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Component
@Slf4j
public class UpdateApplicationChapterManagementService implements UpdateApplicationChapterUseCase {

    private static final String LOG_PREFIX = "[Update Application Chapter Management Service]: ";

    @NonNull
    private final ApplicationChapterPersistencePort applicationChapterPersistencePort;

    @NonNull
    private final Clock clock;

    @Override
    public Optional<ApplicationChapter> updateApplicationChapter(@NonNull UpdatePredefinedOrderNumberOfApplicationChapterCommand command) {
        log.info(LOG_PREFIX + "Update Application Chapter: \"{}\".", command);

        Optional<ApplicationChapter> persistedApplicationChapter = applicationChapterPersistencePort
                .getApplicationChapter(command.getApplicationChapterId());

        if (persistedApplicationChapter.isEmpty()) {
            log.error(LOG_PREFIX + "Cannot Update Application Chapter, cause there is no existing one. Corresponding Command: \"{}\".",
                    command);
            return Optional.empty();
        }

        ApplicationChapter previousApplicationChapter = persistedApplicationChapter.get();

        ApplicationChapter updatedApplicationChapter = new ApplicationChapter(
                previousApplicationChapter.getApplicationChapterId(),
                previousApplicationChapter.getCompanyCodeId(),
                previousApplicationChapter.getApplicationChapterName(),
                command.getPredefinedOrderNumber(),
                previousApplicationChapter.getCreatedAt(),
                OffsetDateTime.now(clock)
        );
        applicationChapterPersistencePort.save(updatedApplicationChapter);

        return Optional.of(updatedApplicationChapter);
    }

}
