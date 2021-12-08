package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.get;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapter;

import java.util.Optional;
import java.util.Set;

public interface GetApplicationChapterUseCase {

    Optional<ApplicationChapter> getApplicationChapter(@NonNull GetApplicationChapterCommand command);

    Set<ApplicationChapter> getApplicationChapters(@NonNull GetAllApplicationChaptersForCompanyCodeCommand command);

}
