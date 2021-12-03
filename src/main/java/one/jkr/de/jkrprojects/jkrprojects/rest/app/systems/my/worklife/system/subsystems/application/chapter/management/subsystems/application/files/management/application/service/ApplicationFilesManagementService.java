package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.S3FileKey;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapterId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.ApplicationFilesUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.GetPresignedDownloadUrlForApplicationFileCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.GetPresignedUploadUrlForApplicationFileCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.RemoveApplicationFileCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.out.AwsS3FileManagerPort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.out.CheckApplicationChapterAvailabilityPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApplicationFilesManagementService implements ApplicationFilesUseCase {

    @NonNull
    private static final String LOG_PREFIX = "[Application Files Management Service]: ";

    @NonNull
    private final AwsS3FileManagerPort awsS3FileManagerPort;

    @NonNull
    private final CheckApplicationChapterAvailabilityPort checkApplicationChapterAvailabilityPort;

    @Value("${my-worklife-system.subsystems.application-files-management.application-files-bucket}")
    private String jkrprojectsMyWorklifeApplicationFilesBucketName;

    @Override
    public Optional<URL> getPresignedDownloadUrl(@NonNull GetPresignedDownloadUrlForApplicationFileCommand command) {
        log.info(LOG_PREFIX + "Create Presigned-Download URL for Command: \"{}\".", command);

        if (!checkApplicationChapterAvailabilityPort.doesApplicationChapterExists(command.getApplicationChapterId())) {
            log.error(LOG_PREFIX + "Application Chapter \"{}\" doesn't exists. Cannot Create a Presigned-Download URL. " +
                    "Corresponding Command: \"{}\".", command.getApplicationChapterId(), command);
            return Optional.empty();
        }

        return Optional.of(awsS3FileManagerPort.createPresignedDownloadUrl(getS3FileKey(command.getApplicationChapterId())));
    }

    @Override
    public Optional<URL> getPresignedUploadUrl(@NonNull GetPresignedUploadUrlForApplicationFileCommand command) {
        log.info(LOG_PREFIX + "Create Presigned-Upload URL for Command: \"{}\".", command);

        if (!checkApplicationChapterAvailabilityPort.doesApplicationChapterExists(command.getApplicationChapterId())) {
            log.error(LOG_PREFIX + "Application Chapter \"{}\" doesn't exists. Cannot Create a Presigned-Upload URL. " +
                    "Corresponding Command: \"{}\".", command.getApplicationChapterId(), command);
            return Optional.empty();
        }

        return Optional.of(awsS3FileManagerPort.createPresignedUploadUrl(getS3FileKey(command.getApplicationChapterId())));
    }

    @Override
    public void removeApplicationFile(@NonNull RemoveApplicationFileCommand command) {
        log.info(LOG_PREFIX + "Delete Application File: \"{}\".", command);

        if (checkApplicationChapterAvailabilityPort.doesApplicationChapterExists(command.getApplicationChapterId())) {
            log.error(LOG_PREFIX + "Application Chapter \"{}\" doesn't exists. Cannot delete the File. " +
                    "Corresponding Command: \"{}\".", command.getApplicationChapterId(), command);
            return;
        }

        awsS3FileManagerPort.deleteFile(getS3FileKey(command.getApplicationChapterId()));
    }

    private S3FileKey getS3FileKey(ApplicationChapterId applicationChapterId) {
        return S3FileKey.createWithoutVersionId(
                jkrprojectsMyWorklifeApplicationFilesBucketName, "application-files",
                applicationChapterId.getId() + ".pdf"
        );
    }
}
