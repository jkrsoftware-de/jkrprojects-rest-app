package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.in.web.payload.data.classes.list.all.application.chapters.by.company.code.id.response;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapter;

import java.util.UUID;

@Value
public class ApplicationChapterDetailsForRestInterface {

    @NonNull
    UUID applicationChapterId;

    @NonNull
    UUID companyCodeId;

    @NonNull
    String applicationChapterName;

    int predefinedOrderNumber;

    public static ApplicationChapterDetailsForRestInterface of(@NonNull ApplicationChapter applicationChapter) {
        return new ApplicationChapterDetailsForRestInterface(
                applicationChapter.getApplicationChapterId().getId(),
                applicationChapter.getCompanyCodeId().getId(),
                applicationChapter.getApplicationChapterName(),
                applicationChapter.getPredefinedOrderNumber()
        );
    }

}