package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.adapters.in.web.payload.data.classes.create.application.chapter.request;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class CreateApplicationChapterRequestPayload {

    @NonNull
    UUID companyCodeId;

    @NonNull
    String applicationChapterName;

    int predefinedOrderNumber;

}
