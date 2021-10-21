package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.adapters.in.web.payload.data.classes.update.application.chapter.response;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class UpdatePredefinedOrderNumberOfApplicationChapterResponsePayload {

    @NonNull
    UUID applicationChapterId;

    int predefinedOrderNumber;

}
