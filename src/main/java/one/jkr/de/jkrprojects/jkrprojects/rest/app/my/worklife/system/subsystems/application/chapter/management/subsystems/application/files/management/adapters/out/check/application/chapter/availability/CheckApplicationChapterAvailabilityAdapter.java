package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.adapters.out.check.application.chapter.availability;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.adapters.in.internal.InternalApplicationChapterManagementAdapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapterId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.out.CheckApplicationChapterAvailabilityPort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckApplicationChapterAvailabilityAdapter implements CheckApplicationChapterAvailabilityPort {

    @NonNull
    private final InternalApplicationChapterManagementAdapter internalApplicationChapterManagementAdapter;

    @Override
    public boolean doesApplicationChapterExists(@NonNull ApplicationChapterId applicationChapterId) {
        return internalApplicationChapterManagementAdapter.getApplicationChapter(applicationChapterId).isPresent();
    }
}
