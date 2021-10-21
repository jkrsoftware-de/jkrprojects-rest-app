package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in;

import lombok.NonNull;

import java.net.URL;
import java.util.Optional;

public interface ApplicationFilesUseCase {

    Optional<URL> getPresignedDownloadUrl(@NonNull GetPresignedDownloadUrlForApplicationFileCommand command);

    Optional<URL> getPresignedUploadUrl(@NonNull GetPresignedUploadUrlForApplicationFileCommand command);

    void removeApplicationFile(@NonNull RemoveApplicationFileCommand command);

}
