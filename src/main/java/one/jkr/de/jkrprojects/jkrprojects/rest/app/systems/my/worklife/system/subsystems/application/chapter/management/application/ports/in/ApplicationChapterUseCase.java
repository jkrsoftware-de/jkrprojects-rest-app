package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapter;

import java.util.Optional;
import java.util.Set;

public interface ApplicationChapterUseCase {

    Optional<ApplicationChapter> getApplicationChapter(@NonNull GetApplicationChapterCommand command);

    Set<ApplicationChapter> getApplicationChapters(@NonNull GetAllApplicationChaptersForCompanyCodeCommand command);

    Optional<ApplicationChapter> createApplicationChapter(@NonNull CreateApplicationChapterCommand command);

    Optional<ApplicationChapter> updateApplicationChapter(@NonNull UpdatePredefinedOrderNumberOfApplicationChapterCommand command);

}
