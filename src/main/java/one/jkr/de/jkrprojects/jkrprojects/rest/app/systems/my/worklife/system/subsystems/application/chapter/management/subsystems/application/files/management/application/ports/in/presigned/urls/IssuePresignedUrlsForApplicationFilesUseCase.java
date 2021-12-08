package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.presigned.urls;

import lombok.NonNull;

import java.net.URL;
import java.util.Optional;

public interface IssuePresignedUrlsForApplicationFilesUseCase {

    Optional<URL> getPresignedDownloadUrl(@NonNull GetPresignedDownloadUrlForApplicationFileCommand command);

    Optional<URL> getPresignedUploadUrl(@NonNull GetPresignedUploadUrlForApplicationFileCommand command);

}
