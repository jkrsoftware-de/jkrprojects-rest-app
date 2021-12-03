package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.out;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.S3FileKey;

import java.net.URL;

public interface AwsS3FileManagerPort {

    URL createPresignedDownloadUrl(@NonNull S3FileKey source);

    URL createPresignedUploadUrl(@NonNull S3FileKey destination);

    void deleteFile(@NonNull S3FileKey fileToDelete);

}
