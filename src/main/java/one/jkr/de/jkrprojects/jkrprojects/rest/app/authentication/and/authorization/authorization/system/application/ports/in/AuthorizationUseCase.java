package one.jkr.de.jkrprojects.jkrprojects.rest.app.authentication.and.authorization.authorization.system.application.ports.in;

import lombok.NonNull;

public interface AuthorizationUseCase {

    boolean isAuthorized(@NonNull CheckAuthorizationForCompanyCodeCommand command);

    boolean isAuthorized(@NonNull CheckSystemClientAuthorizationCommand command);

}
