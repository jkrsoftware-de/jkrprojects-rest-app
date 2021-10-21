package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.adapters.out.delete.application.file;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.application.ports.out.DeleteApplicationFilePort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapterId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.adapters.in.InternalApplicationFilesManagementAdapter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteApplicationFileAdapter implements DeleteApplicationFilePort {

    @NonNull
    private final InternalApplicationFilesManagementAdapter internalApplicationFilesManagementAdapter;

    @Override
    public void deleteApplicationFile(@NonNull ApplicationChapterId applicationChapterId) {
        internalApplicationFilesManagementAdapter.removeApplicationFile(applicationChapterId);
    }
}
