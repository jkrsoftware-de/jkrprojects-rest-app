package one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.application.ports.in;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.S3FileKey;

public interface AwsS3DeleteUseCase {

    void deleteFile(@NonNull S3FileKey fileToDelete);

}
