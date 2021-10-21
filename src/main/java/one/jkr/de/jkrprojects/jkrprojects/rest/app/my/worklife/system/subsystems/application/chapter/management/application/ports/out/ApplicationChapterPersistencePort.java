package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.application.ports.out;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapterId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;

import java.util.Optional;
import java.util.Set;

public interface ApplicationChapterPersistencePort {

    Optional<ApplicationChapter> getApplicationChapter(@NonNull ApplicationChapterId applicationChapterId);

    Set<ApplicationChapter> getApplicationChapters(@NonNull CompanyCodeId companyCodeId);

    void save(@NonNull ApplicationChapter applicationChapter);

    void remove(@NonNull ApplicationChapterId applicationChapterId);

}
