package one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain;

import lombok.NonNull;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Optional;

@Value
@NonFinal
public class S3FileKey {

    @NonNull
    String bucketName;

    @NonNull
    String s3BucketPath;

    @NonNull
    String fileName;

    @NonNull
    Optional<String> versionId;

    public static S3FileKey createWithVersionId(@NonNull String bucketName, @NonNull String s3BucketPath, @NonNull String fileName,
                                                @NonNull Optional<String> versionId) {
        return new S3FileKey(bucketName, s3BucketPath, fileName, versionId);
    }

    public static S3FileKey createWithoutVersionId(@NonNull String bucketName, @NonNull String s3BucketPath, @NonNull String fileName) {
        return new S3FileKey(bucketName, s3BucketPath, fileName, Optional.empty());
    }
}
