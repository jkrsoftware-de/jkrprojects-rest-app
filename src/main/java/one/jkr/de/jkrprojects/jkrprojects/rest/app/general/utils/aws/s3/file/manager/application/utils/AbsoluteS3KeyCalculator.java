package one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.application.utils;

import one.jkr.de.jkrprojects.jkrprojects.rest.app.general.utils.aws.s3.file.manager.domain.S3FileKey;

public class AbsoluteS3KeyCalculator {

    public static String getAbsolutS3Key(S3FileKey s3FileKey) {
        return s3FileKey.getS3BucketPath() + "/" + s3FileKey.getFileName();
    }

}
