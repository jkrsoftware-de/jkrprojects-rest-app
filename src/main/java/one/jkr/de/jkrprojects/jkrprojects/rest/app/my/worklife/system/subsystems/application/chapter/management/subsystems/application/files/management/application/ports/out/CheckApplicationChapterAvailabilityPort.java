package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.out;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapterId;

public interface CheckApplicationChapterAvailabilityPort {

    boolean doesApplicationChapterExists(@NonNull ApplicationChapterId applicationChapterId);

}
