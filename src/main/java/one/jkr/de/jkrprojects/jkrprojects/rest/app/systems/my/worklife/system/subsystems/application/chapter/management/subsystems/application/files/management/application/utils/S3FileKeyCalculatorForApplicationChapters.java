package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.utils;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.S3FileKey;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapterId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class S3FileKeyCalculatorForApplicationChapters {

    @Value("${my-worklife-system.subsystems.application-files-management.application-files-bucket}")
    private String jkrprojectsMyWorklifeApplicationFilesBucketName;

    public S3FileKey getS3FileKey(@NonNull ApplicationChapterId applicationChapterId) {
        return S3FileKey.createWithoutVersionId(
                jkrprojectsMyWorklifeApplicationFilesBucketName, "application-files",
                applicationChapterId.getId() + ".pdf"
        );
    }

}
