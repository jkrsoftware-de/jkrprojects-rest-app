package one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.application.ports.in;

import lombok.NonNull;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.AdditionalUploadMetaInformations;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.FileUploadMetaInformations;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.S3FileKey;

import java.io.File;
import java.net.URL;

public interface AwsS3UploadUseCase {

    FileUploadMetaInformations uploadFile(@NonNull S3FileKey destination, @NonNull File fileToUpload);

    FileUploadMetaInformations uploadFile(@NonNull S3FileKey destination, @NonNull File fileToUpload,
                                          @NonNull AdditionalUploadMetaInformations additionalUploadMetaInformations);

    URL createPresignedUploadUrl(@NonNull S3FileKey destination);

}
