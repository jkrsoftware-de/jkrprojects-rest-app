package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.adapters.in;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapterId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.ApplicationFilesUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.GetPresignedDownloadUrlForApplicationFileCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.GetPresignedUploadUrlForApplicationFileCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.RemoveApplicationFileCommand;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class InternalApplicationFilesManagementAdapter {

    private static final String LOG_PREFIX = "[Internal Files Management Adapter]: ";

    @NonNull
    private final ApplicationFilesUseCase applicationFilesUseCase;

    public Optional<URL> getPresignedDownloadUrl(@NonNull ApplicationChapterId applicationChapterId) {
        return applicationFilesUseCase.getPresignedDownloadUrl(
                new GetPresignedDownloadUrlForApplicationFileCommand(applicationChapterId)
        );
    }

    public Optional<URL> getPresignedUploadUrl(@NonNull ApplicationChapterId applicationChapterId) {
        return applicationFilesUseCase.getPresignedUploadUrl(
                new GetPresignedUploadUrlForApplicationFileCommand(applicationChapterId)
        );
    }

    public void removeApplicationFile(@NonNull ApplicationChapterId applicationChapterId) {
        applicationFilesUseCase.removeApplicationFile(
                new RemoveApplicationFileCommand(applicationChapterId)
        );
    }

}
