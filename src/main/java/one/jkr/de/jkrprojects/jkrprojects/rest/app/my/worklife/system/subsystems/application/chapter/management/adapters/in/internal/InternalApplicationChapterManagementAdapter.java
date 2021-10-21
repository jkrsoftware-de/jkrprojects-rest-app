package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.adapters.in.internal;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.application.ports.in.ApplicationChapterUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.application.ports.in.GetApplicationChapterCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapterId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class InternalApplicationChapterManagementAdapter {

    @NonNull
    private final ApplicationChapterUseCase applicationChapterUseCase;

    public Optional<ApplicationChapter> getApplicationChapter(@NonNull ApplicationChapterId applicationChapterId) {
        return applicationChapterUseCase.getApplicationChapter(
                new GetApplicationChapterCommand(applicationChapterId)
        );
    }

}
