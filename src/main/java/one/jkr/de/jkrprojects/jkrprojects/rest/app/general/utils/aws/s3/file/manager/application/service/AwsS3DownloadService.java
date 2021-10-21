package one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.application.service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.application.ports.in.AwsS3DownloadUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.application.utils.AbsoluteS3KeyCalculator;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.S3FileKey;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.time.Clock;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class AwsS3DownloadService implements AwsS3DownloadUseCase {

    private static final String LOG_PREFIX = "[AWS S3 Download Service]: ";

    @NonNull
    private final AmazonS3 amazonS3Client;

    @NonNull
    private final Clock clock;

    @Override
    public Optional<File> downloadFile(@NonNull S3FileKey source) {
        // not implemented yet.
        return Optional.empty();
    }

    @Override
    public URL createPresignedDownloadUrl(@NonNull S3FileKey source) {
        log.info(LOG_PREFIX + "Create Presigned-Upload URL for S3-Source: \"{}\".", source);

        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(
                source.getBucketName(), AbsoluteS3KeyCalculator.getAbsolutS3Key(source))
                .withMethod(HttpMethod.GET)
                .withExpiration(Date.from(Instant.now(clock).plus(1, ChronoUnit.HOURS)));

        if (source.getVersionId().isPresent()) {
            generatePresignedUrlRequest.withVersionId(source.getVersionId().get());
        }

        return amazonS3Client.generatePresignedUrl(generatePresignedUrlRequest);
    }
}
