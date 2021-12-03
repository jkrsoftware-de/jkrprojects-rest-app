package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.*;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.out.ApplicationChapterPersistencePort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.out.CheckCompanyCodeAvailabilityPort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapterId;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApplicationChapterManagementService implements ApplicationChapterUseCase {

    private static final String LOG_PREFIX = "[Application Chapter Management Service]: ";

    @NonNull
    private final ApplicationChapterPersistencePort persistencePort;

    @NonNull
    private final CheckCompanyCodeAvailabilityPort checkCompanyCodeAvailabilityPort;

    @NonNull
    private final Clock clock;

    @Override
    public Optional<ApplicationChapter> getApplicationChapter(@NonNull GetApplicationChapterCommand command) {
        log.info(LOG_PREFIX + "Get Application Chapter: \"{}\".", command);

        return persistencePort.getApplicationChapter(command.getApplicationChapterId());
    }

    @Override
    public Set<ApplicationChapter> getApplicationChapters(@NonNull GetAllApplicationChaptersForCompanyCodeCommand command) {
        log.info(LOG_PREFIX + "Get Set of All Application Chapters: \"{}\".", command);

        return persistencePort.getApplicationChapters(command.getCompanyCodeId())
                .stream()
                .sorted(Comparator.comparing(ApplicationChapter::getPredefinedOrderNumber))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public Optional<ApplicationChapter> createApplicationChapter(@NonNull CreateApplicationChapterCommand command) {
        log.info(LOG_PREFIX + "Create Application Chapter: \"{}\".", command);

        if (!checkCompanyCodeAvailabilityPort.doesCompanyCodeExists(command.getCompanyCodeId())) {
            log.error(LOG_PREFIX + "Cannot Create Application Chapter, cause the corresponding Company Code does not exists. " +
                    "Corresponding Command: \"{}\".", command);
            return Optional.empty();
        }

        ApplicationChapter newApplicationChapter = new ApplicationChapter(
                new ApplicationChapterId(UUID.randomUUID()),
                command.getCompanyCodeId(),
                command.getApplicationChapterName(),
                command.getPredefinedOrderNumber(),
                OffsetDateTime.now(clock),
                OffsetDateTime.now(clock)
        );
        persistencePort.save(newApplicationChapter);

        log.info(LOG_PREFIX + "Created Application Chapter \"{}\" for Command: \"{}\".", newApplicationChapter.getApplicationChapterId(),
                command);
        return Optional.of(newApplicationChapter);
    }

    @Override
    public Optional<ApplicationChapter> updateApplicationChapter(@NonNull UpdatePredefinedOrderNumberOfApplicationChapterCommand command) {
        log.info(LOG_PREFIX + "Update Application Chapter: \"{}\".", command);

        Optional<ApplicationChapter> persistedApplicationChapter = persistencePort.getApplicationChapter(command.getApplicationChapterId());

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
        persistencePort.save(updatedApplicationChapter);

        return Optional.of(updatedApplicationChapter);
    }
}
