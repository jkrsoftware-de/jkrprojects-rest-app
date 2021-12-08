package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.in.remove;

import lombok.NonNull;

public interface RemoveApplicationFilesUseCase {

    void removeApplicationFile(@NonNull RemoveApplicationFileCommand command);

}
