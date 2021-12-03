package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.in.web.payload.data.classes.update.application.chapter.request;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class UpdatePredefinedOrderNumberOfApplicationChapterRequestPayload {

    int predefinedOrderNumber;

}
