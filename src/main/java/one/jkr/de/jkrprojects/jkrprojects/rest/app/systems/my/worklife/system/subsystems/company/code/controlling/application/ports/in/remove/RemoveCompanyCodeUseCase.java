package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.application.ports.in.remove;

import lombok.NonNull;

public interface RemoveCompanyCodeUseCase {

    boolean remove(@NonNull RemoveCompanyCodeCommand command);

}
