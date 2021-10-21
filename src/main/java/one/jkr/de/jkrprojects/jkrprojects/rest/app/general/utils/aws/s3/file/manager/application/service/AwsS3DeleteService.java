package one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.application.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.application.ports.in.AwsS3DeleteUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.application.utils.AbsoluteS3KeyCalculator;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.S3FileKey;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AwsS3DeleteService implements AwsS3DeleteUseCase {

    private static final String LOG_PREFIX = "[AWS S3 Delete Service]: ";

    @NonNull
    private final AmazonS3 amazonS3Client;

    @Override
    public void deleteFile(@NonNull S3FileKey fileToDelete) {
        log.info(LOG_PREFIX + "Delete S3-File: \"{}\".", fileToDelete);
        amazonS3Client.deleteObject(
                new DeleteObjectRequest(fileToDelete.getBucketName(), AbsoluteS3KeyCalculator.getAbsolutS3Key(fileToDelete))
        );
    }

}
