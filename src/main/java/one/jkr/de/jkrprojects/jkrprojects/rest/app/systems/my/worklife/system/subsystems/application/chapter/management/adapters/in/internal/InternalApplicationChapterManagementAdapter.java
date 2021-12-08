package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.in.internal;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.get.GetAllApplicationChaptersForCompanyCodeCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.get.GetApplicationChapterCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.get.GetApplicationChapterUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.remove.RemoveApplicationChapterCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.remove.RemoveApplicationChapterUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapterId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class InternalApplicationChapterManagementAdapter {

    @NonNull
    private final GetApplicationChapterUseCase getApplicationChapterUseCase;

    @NonNull
    private final RemoveApplicationChapterUseCase removeApplicationChapterUseCase;

    public Optional<ApplicationChapter> getApplicationChapter(@NonNull ApplicationChapterId applicationChapterId) {
        return getApplicationChapterUseCase.getApplicationChapter(
                new GetApplicationChapterCommand(applicationChapterId)
        );
    }

    public Set<ApplicationChapter> getApplicationChapters(@NonNull CompanyCodeId companyCodeId) {
        return getApplicationChapterUseCase.getApplicationChapters(
                new GetAllApplicationChaptersForCompanyCodeCommand(companyCodeId)
        );
    }

    public boolean removeApplicationChapter(@NonNull ApplicationChapterId applicationChapterId) {
        return removeApplicationChapterUseCase.removeApplicationChapter(
                new RemoveApplicationChapterCommand(applicationChapterId)
        );
    }

}
