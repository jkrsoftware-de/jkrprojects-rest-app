package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.in.web.payload.data.classes.get.presigned.url.response;

import lombok.NonNull;
import lombok.Value;

import java.net.URL;

@Value
public class GetPresignedUrlResponsePayload {

    @NonNull
    URL presignedUrl;

}
