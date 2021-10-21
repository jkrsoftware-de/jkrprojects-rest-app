package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.domain;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class ApplicationFileId {

    @NonNull
    UUID id;

}
