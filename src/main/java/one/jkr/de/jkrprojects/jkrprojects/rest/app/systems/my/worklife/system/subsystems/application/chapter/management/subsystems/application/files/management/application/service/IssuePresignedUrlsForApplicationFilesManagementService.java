package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.presigned.urls.GetPresignedDownloadUrlForApplicationFileCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.presigned.urls.GetPresignedUploadUrlForApplicationFileCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.presigned.urls.IssuePresignedUrlsForApplicationFilesUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.out.AwsS3FileManagerPort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.out.CheckApplicationChapterAvailabilityPort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.utils.S3FileKeyCalculatorForApplicationChapters;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class IssuePresignedUrlsForApplicationFilesManagementService implements IssuePresignedUrlsForApplicationFilesUseCase {

    @NonNull
    private static final String LOG_PREFIX = "[Application Files Management Service]: ";

    @NonNull
    private final AwsS3FileManagerPort awsS3FileManagerPort;

    @NonNull
    private final CheckApplicationChapterAvailabilityPort checkApplicationChapterAvailabilityPort;

    @NonNull
    private final S3FileKeyCalculatorForApplicationChapters s3FileKeyCalculatorForApplicationChapters;

    @Override
    public Optional<URL> getPresignedDownloadUrl(@NonNull GetPresignedDownloadUrlForApplicationFileCommand command) {
        log.info(LOG_PREFIX + "Create Presigned-Download URL for Command: \"{}\".", command);

        if (!checkApplicationChapterAvailabilityPort.doesApplicationChapterExists(command.getApplicationChapterId())) {
            log.error(LOG_PREFIX + "Application Chapter \"{}\" doesn't exists. Cannot Create a Presigned-Download URL. " +
                    "Corresponding Command: \"{}\".", command.getApplicationChapterId(), command);
            return Optional.empty();
        }

        return Optional.of(
                awsS3FileManagerPort.createPresignedDownloadUrl(
                        s3FileKeyCalculatorForApplicationChapters.getS3FileKey(command.getApplicationChapterId())
                )
        );
    }

    @Override
    public Optional<URL> getPresignedUploadUrl(@NonNull GetPresignedUploadUrlForApplicationFileCommand command) {
        log.info(LOG_PREFIX + "Create Presigned-Upload URL for Command: \"{}\".", command);

        if (!checkApplicationChapterAvailabilityPort.doesApplicationChapterExists(command.getApplicationChapterId())) {
            log.error(LOG_PREFIX + "Application Chapter \"{}\" doesn't exists. Cannot Create a Presigned-Upload URL. " +
                    "Corresponding Command: \"{}\".", command.getApplicationChapterId(), command);
            return Optional.empty();
        }

        return Optional.of(
                awsS3FileManagerPort.createPresignedUploadUrl(
                        s3FileKeyCalculatorForApplicationChapters.getS3FileKey(command.getApplicationChapterId())
                )
        );
    }


}
