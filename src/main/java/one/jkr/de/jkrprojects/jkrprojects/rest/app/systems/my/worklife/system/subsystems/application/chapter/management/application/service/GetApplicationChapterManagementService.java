package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.get.GetAllApplicationChaptersForCompanyCodeCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.get.GetApplicationChapterCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.get.GetApplicationChapterUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.out.ApplicationChapterPersistencePort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapter;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class GetApplicationChapterManagementService implements GetApplicationChapterUseCase {

    private static final String LOG_PREFIX = "[Get Application Chapter Management Service]: ";

    @NonNull
    private final ApplicationChapterPersistencePort applicationChapterPersistencePort;

    @Override
    public Optional<ApplicationChapter> getApplicationChapter(@NonNull GetApplicationChapterCommand command) {
        log.info(LOG_PREFIX + "Get Application Chapter: \"{}\".", command);

        return applicationChapterPersistencePort.getApplicationChapter(command.getApplicationChapterId());
    }

    @Override
    public Set<ApplicationChapter> getApplicationChapters(@NonNull GetAllApplicationChaptersForCompanyCodeCommand command) {
        log.info(LOG_PREFIX + "Get Set of all Application Chapters: \"{}\".", command);

        return applicationChapterPersistencePort.getApplicationChapters(command.getCompanyCodeId())
                .stream()
                .sorted(Comparator.comparing(ApplicationChapter::getPredefinedOrderNumber))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

}
