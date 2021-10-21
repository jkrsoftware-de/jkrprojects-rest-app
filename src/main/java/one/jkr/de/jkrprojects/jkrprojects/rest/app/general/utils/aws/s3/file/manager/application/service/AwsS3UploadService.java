package one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.application.service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.google.common.base.Stopwatch;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.application.ports.in.AwsS3UploadUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.application.utils.AbsoluteS3KeyCalculator;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.AdditionalUploadMetaInformations;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.FileUploadMetaInformations;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.S3FileKey;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.time.Clock;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
@Slf4j
public class AwsS3UploadService implements AwsS3UploadUseCase {

    private static final String LOG_PREFIX = "[AWS S3 Upload Service]: ";

    @NonNull
    private final AmazonS3 amazonS3Client;

    @NonNull
    private final Clock clock;

    @Override
    public FileUploadMetaInformations uploadFile(@NonNull S3FileKey destination, @NonNull File fileToUpload) {
        return uploadFile(destination, fileToUpload, new AdditionalUploadMetaInformations(Optional.empty(), Optional.empty()));
    }

    @Override
    public FileUploadMetaInformations uploadFile(@NonNull S3FileKey destination, @NonNull File fileToUpload,
                                                 @NonNull AdditionalUploadMetaInformations additionalUploadMetaInformations) {
        log.info(LOG_PREFIX + "Upload File \"{}\" to S3-Destination \"{}\".", fileToUpload.getAbsolutePath(), destination);

        Stopwatch stopwatch = Stopwatch.createStarted();
        PutObjectRequest putObjectRequest = new PutObjectRequest(
                destination.getBucketName(), AbsoluteS3KeyCalculator.getAbsolutS3Key(destination), fileToUpload);

        if (additionalUploadMetaInformations.getAccessControlList().isPresent()) {
            putObjectRequest.withAccessControlList(additionalUploadMetaInformations.getAccessControlList().get());
        }
        if (additionalUploadMetaInformations.getCannedAccessControlList().isPresent()) {
            putObjectRequest.withCannedAcl(additionalUploadMetaInformations.getCannedAccessControlList().get());
        }

        PutObjectResult putObjectResult = amazonS3Client.putObject(putObjectRequest);
        stopwatch.stop();

        return new FileUploadMetaInformations(
                S3FileKey.createWithVersionId(destination.getBucketName(), destination.getS3BucketPath(), destination.getFileName(),
                        getOptionalOfS3VersionId(putObjectResult.getVersionId())),
                fileToUpload.length(), stopwatch.elapsed(TimeUnit.MILLISECONDS)
        );
    }

    @Override
    public URL createPresignedUploadUrl(@NonNull S3FileKey destination) {
        log.info(LOG_PREFIX + "Create Presigned-Upload URL for S3-Destination: \"{}\".", destination);

        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(
                destination.getBucketName(), AbsoluteS3KeyCalculator.getAbsolutS3Key(destination))
                .withMethod(HttpMethod.PUT)
                .withExpiration(Date.from(Instant.now(clock).plus(1, ChronoUnit.HOURS)));

        return amazonS3Client.generatePresignedUrl(generatePresignedUrlRequest);
    }

    private Optional<String> getOptionalOfS3VersionId(String versionId) {
        if (versionId.equals("")) {
            return Optional.empty();
        } else {
            return Optional.of(versionId);
        }
    }
}
