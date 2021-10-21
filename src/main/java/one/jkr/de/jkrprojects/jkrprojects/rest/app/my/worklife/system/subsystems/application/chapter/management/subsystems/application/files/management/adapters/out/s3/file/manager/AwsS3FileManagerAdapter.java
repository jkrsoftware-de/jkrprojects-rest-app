package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.adapters.out.s3.file.manager;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.adapters.in.InternalAwsS3FileManagerAdapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.S3FileKey;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.application.ports.out.AwsS3FileManagerPort;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
@RequiredArgsConstructor
public class AwsS3FileManagerAdapter implements AwsS3FileManagerPort {

    private final InternalAwsS3FileManagerAdapter internalAwsS3FileManagerAdapter;

    @Override
    public URL createPresignedDownloadUrl(@NonNull S3FileKey source) {
        return internalAwsS3FileManagerAdapter.createPresignedDownloadUrl(source);
    }

    @Override
    public URL createPresignedUploadUrl(@NonNull S3FileKey destination) {
        return internalAwsS3FileManagerAdapter.createPresignedUploadUrl(destination);
    }

    @Override
    public void deleteFile(@NonNull S3FileKey fileToDelete) {
        internalAwsS3FileManagerAdapter.deleteFile(fileToDelete);
    }
}
