package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;

@Value
public class CreateApplicationChapterCommand {

    @NonNull
    CompanyCodeId companyCodeId;

    @NonNull
    String applicationChapterName;

    int predefinedOrderNumber;

}
