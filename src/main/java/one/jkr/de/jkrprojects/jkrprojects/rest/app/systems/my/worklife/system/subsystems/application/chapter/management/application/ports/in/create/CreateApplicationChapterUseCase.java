package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.create;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapter;

import java.util.Optional;

public interface CreateApplicationChapterUseCase {

    Optional<ApplicationChapter> createApplicationChapter(@NonNull CreateApplicationChapterCommand command);

}
