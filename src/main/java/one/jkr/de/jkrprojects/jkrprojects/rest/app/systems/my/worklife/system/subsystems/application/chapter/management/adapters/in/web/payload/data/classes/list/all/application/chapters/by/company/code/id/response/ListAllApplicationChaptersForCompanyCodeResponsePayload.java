package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.in.web.payload.data.classes.list.all.application.chapters.by.company.code.id.response;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapter;

import java.util.Set;

@Value
public class ListAllApplicationChaptersForCompanyCodeResponsePayload {

    @NonNull
    Set<ApplicationChapter> applicationChapters;

}
