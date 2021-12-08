package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.remove.RemoveApplicationChapterCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.remove.RemoveApplicationChapterUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.out.ApplicationChapterPersistencePort;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.out.DeleteApplicationFilePort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RemoveApplicationChapterManagementService implements RemoveApplicationChapterUseCase {

    @NonNull
    private final ApplicationChapterPersistencePort applicationChapterPersistencePort;

    @NonNull
    private final DeleteApplicationFilePort deleteApplicationFilePort;

    @Override
    public boolean removeApplicationChapter(@NonNull RemoveApplicationChapterCommand command) {
        deleteApplicationFilePort.deleteApplicationFile(command.getApplicationChapterToDelete());
        return applicationChapterPersistencePort.remove(command.getApplicationChapterToDelete());
    }

}
