package one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain;

import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import lombok.NonNull;
import lombok.Value;

import java.util.Optional;

@Value
public class AdditionalUploadMetaInformations {

    @NonNull
    Optional<AccessControlList> accessControlList;

    @NonNull
    Optional<CannedAccessControlList> cannedAccessControlList;

}
