package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapterId;

@Value
public class GetPresignedUploadUrlForApplicationFileCommand {

    @NonNull
    ApplicationChapterId applicationChapterId;

}
