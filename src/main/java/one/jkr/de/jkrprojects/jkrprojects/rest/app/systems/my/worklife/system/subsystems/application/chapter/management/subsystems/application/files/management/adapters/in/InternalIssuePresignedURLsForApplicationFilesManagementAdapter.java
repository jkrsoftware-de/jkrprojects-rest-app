package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.adapters.in;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapterId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.presigned.urls.GetPresignedDownloadUrlForApplicationFileCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.presigned.urls.GetPresignedUploadUrlForApplicationFileCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.presigned.urls.IssuePresignedUrlsForApplicationFilesUseCase;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class InternalIssuePresignedURLsForApplicationFilesManagementAdapter {

    @NonNull
    private final IssuePresignedUrlsForApplicationFilesUseCase issuePresignedUrlsForApplicationFilesUseCase;

    public Optional<URL> getPresignedDownloadUrl(@NonNull ApplicationChapterId applicationChapterId) {
        return issuePresignedUrlsForApplicationFilesUseCase.getPresignedDownloadUrl(
                new GetPresignedDownloadUrlForApplicationFileCommand(applicationChapterId)
        );
    }

    public Optional<URL> getPresignedUploadUrl(@NonNull ApplicationChapterId applicationChapterId) {
        return issuePresignedUrlsForApplicationFilesUseCase.getPresignedUploadUrl(
                new GetPresignedUploadUrlForApplicationFileCommand(applicationChapterId)
        );
    }

}
