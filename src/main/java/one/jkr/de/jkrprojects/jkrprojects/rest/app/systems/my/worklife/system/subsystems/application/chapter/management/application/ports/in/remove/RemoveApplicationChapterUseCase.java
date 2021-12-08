package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.remove;

import lombok.NonNull;

public interface RemoveApplicationChapterUseCase {

    boolean removeApplicationChapter(@NonNull RemoveApplicationChapterCommand command);

}
