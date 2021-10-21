package one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.adapters.in;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.application.ports.in.AwsS3DeleteUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.application.ports.in.AwsS3DownloadUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.application.ports.in.AwsS3UploadUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.AdditionalUploadMetaInformations;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.FileUploadMetaInformations;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.S3FileKey;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class InternalAwsS3FileManagerAdapter {

    @NonNull
    private final AwsS3DownloadUseCase awsS3DownloadUseCase;

    @NonNull
    private final AwsS3UploadUseCase awsS3UploadUseCase;

    @NonNull
    private final AwsS3DeleteUseCase awsS3DeleteUseCase;

    public Optional<File> downloadFile(@NonNull S3FileKey source) {
        return awsS3DownloadUseCase.downloadFile(source);
    }

    public URL createPresignedDownloadUrl(@NonNull S3FileKey source) {
        return awsS3DownloadUseCase.createPresignedDownloadUrl(source);
    }

    public FileUploadMetaInformations uploadFile(@NonNull S3FileKey destination, @NonNull File fileToUpload) {
        return awsS3UploadUseCase.uploadFile(destination, fileToUpload);
    }

    public FileUploadMetaInformations uploadFile(@NonNull S3FileKey destination, @NonNull File fileToUpload,
                                                 @NonNull AdditionalUploadMetaInformations additionalUploadMetaInformations) {
        return awsS3UploadUseCase.uploadFile(destination, fileToUpload, additionalUploadMetaInformations);
    }

    public URL createPresignedUploadUrl(@NonNull S3FileKey destination) {
        return awsS3UploadUseCase.createPresignedUploadUrl(destination);
    }

    public void deleteFile(@NonNull S3FileKey fileToDelete) {
        awsS3DeleteUseCase.deleteFile(fileToDelete);
    }
}
