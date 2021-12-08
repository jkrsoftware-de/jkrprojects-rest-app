package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.adapters.in;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapterId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.remove.RemoveApplicationFileCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.remove.RemoveApplicationFilesUseCase;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class InternalRemoveApplicationFilesManagementAdapter {

    private static final String LOG_PREFIX = "[Internal Remove Application Files Management Adapter]: ";

    @NonNull
    private final RemoveApplicationFilesUseCase removeApplicationFile;

    public void removeApplicationFile(@NonNull ApplicationChapterId applicationChapterId) {
        removeApplicationFile.removeApplicationFile(
                new RemoveApplicationFileCommand(applicationChapterId)
        );
    }

}
