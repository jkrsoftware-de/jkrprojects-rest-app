package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;

import java.time.OffsetDateTime;

@Value
public class ApplicationChapter {

    @NonNull
    ApplicationChapterId applicationChapterId;

    @NonNull
    CompanyCodeId companyCodeId;

    @NonNull
    String applicationChapterName;

    int predefinedOrderNumber;

    @NonNull
    OffsetDateTime createdAt;

    @NonNull
    OffsetDateTime lastModified;

}
