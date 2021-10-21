package one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.application.ports.in;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.S3FileKey;

import java.io.File;
import java.net.URL;
import java.util.Optional;

public interface AwsS3DownloadUseCase {

    Optional<File> downloadFile(@NonNull S3FileKey source);

    URL createPresignedDownloadUrl(@NonNull S3FileKey source);

}
