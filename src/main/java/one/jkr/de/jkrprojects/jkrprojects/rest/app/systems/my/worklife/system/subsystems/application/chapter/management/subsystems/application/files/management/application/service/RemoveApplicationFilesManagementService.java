package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.remove.RemoveApplicationFileCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.remove.RemoveApplicationFilesUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.out.AwsS3FileManagerPort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.utils.S3FileKeyCalculatorForApplicationChapters;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RemoveApplicationFilesManagementService implements RemoveApplicationFilesUseCase {

    @NonNull
    private static final String LOG_PREFIX = "[Application Files Management Service]: ";

    @NonNull
    private final AwsS3FileManagerPort awsS3FileManagerPort;

    @NonNull
    private final S3FileKeyCalculatorForApplicationChapters s3FileKeyCalculatorForApplicationChapters;

    @Override
    public void removeApplicationFile(@NonNull RemoveApplicationFileCommand command) {
        log.info(LOG_PREFIX + "Delete Application File, if exists: \"{}\".", command);
        awsS3FileManagerPort.deleteFile(s3FileKeyCalculatorForApplicationChapters.getS3FileKey(command.getApplicationChapterId()));
    }

}
