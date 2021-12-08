package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.create.CreateApplicationChapterCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.create.CreateApplicationChapterUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.out.ApplicationChapterPersistencePort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.out.CheckCompanyCodeAvailabilityPort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapterId;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateApplicationChapterManagementService implements CreateApplicationChapterUseCase {

    private static final String LOG_PREFIX = "[Create Application Chapter Management Service]: ";

    @NonNull
    private final ApplicationChapterPersistencePort applicationChapterPersistencePort;

    @NonNull
    private final CheckCompanyCodeAvailabilityPort checkCompanyCodeAvailabilityPort;

    @NonNull
    private final Clock clock;

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
        applicationChapterPersistencePort.save(newApplicationChapter);

        log.info(LOG_PREFIX + "Created Application Chapter \"{}\" for Command: \"{}\".", newApplicationChapter.getApplicationChapterId(),
                command);
        return Optional.of(newApplicationChapter);
    }

}
