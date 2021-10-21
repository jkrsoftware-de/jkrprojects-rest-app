package one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain;

import lombok.NonNull;
import lombok.Value;

@Value
public class FileDownloadMetaInformations {

    @NonNull
    S3FileKey s3FileKey;

    long fileSizeOfUploadedFileInByte;

    long fileUploadDurationInSeconds;

}
