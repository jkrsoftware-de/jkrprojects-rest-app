package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.in.web;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authorization.system.adapters.in.internal.rest.controllers.InternalAuthorizationSystemAdapterForRestControllers;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.authentication.and.authorization.authorization.system.adapters.in.internal.rest.controllers.rest.exceptions.NoAuthorizationRestException;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.in.web.payload.data.classes.create.application.chapter.request.CreateApplicationChapterRequestPayload;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.in.web.payload.data.classes.create.application.chapter.response.CreateApplicationChapterResponsePayload;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.in.web.payload.data.classes.get.presigned.url.response.GetPresignedUrlResponsePayload;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.in.web.payload.data.classes.list.all.application.chapters.by.company.code.id.response.ListAllApplicationChaptersForCompanyCodeResponsePayload;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.in.web.payload.data.classes.update.application.chapter.request.UpdatePredefinedOrderNumberOfApplicationChapterRequestPayload;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.in.web.payload.data.classes.update.application.chapter.response.UpdatePredefinedOrderNumberOfApplicationChapterResponsePayload;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.*;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapterId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.adapters.in.InternalApplicationFilesManagementAdapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ApplicationChapterManagementRestController {

    private static final String LOG_PREFIX = "[Files Management REST-Controller]: ";

    @NonNull
    private final InternalAuthorizationSystemAdapterForRestControllers internalAuthorizationSystemAdapterForRestControllers;

    @NonNull
    private final InternalApplicationFilesManagementAdapter internalApplicationFilesManagementAdapter;

    @NonNull
    private final ApplicationChapterUseCase applicationChapterUseCase;

    @RequestMapping(value = "/chapter-management/list-all/by-company-code-id/{companyCodeId}", method = RequestMethod.GET)
    public ResponseEntity<?> listAllApplicationChaptersForCompanyCode(@RequestHeader("Authorization") @NonNull String authorizationHeader,
                                                                      @PathVariable @NonNull UUID companyCodeId)
            throws NoAuthorizationRestException {
        internalAuthorizationSystemAdapterForRestControllers.checkAuthorizationForCompanyCode(authorizationHeader, companyCodeId);

        log.info(LOG_PREFIX + "List all Application Chapters for CompanyCode: \"{}\".", companyCodeId);
        Set<ApplicationChapter> applicationChapters = applicationChapterUseCase.getApplicationChapters(
                new GetAllApplicationChaptersForCompanyCodeCommand(new CompanyCodeId(companyCodeId))
        );

        if (applicationChapters.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(new ListAllApplicationChaptersForCompanyCodeResponsePayload(applicationChapters));
    }

    @RequestMapping(value = "/chapter-management/application-chapter", method = RequestMethod.POST)
    public ResponseEntity<?> createNewApplicationChapter(
            @RequestHeader("Authorization") @NonNull String authorizationHeader,
            @RequestBody @NonNull CreateApplicationChapterRequestPayload payload) throws NoAuthorizationRestException {
        internalAuthorizationSystemAdapterForRestControllers.checkSystemClientAuthorization(authorizationHeader);

        log.info(LOG_PREFIX + "Create Application Chapter: \"{}\".", payload);
        Optional<ApplicationChapter> createdApplicationChapter = applicationChapterUseCase.createApplicationChapter(
                new CreateApplicationChapterCommand(
                        new CompanyCodeId(payload.getCompanyCodeId()), payload.getApplicationChapterName(),
                        payload.getPredefinedOrderNumber())
        );

        if (createdApplicationChapter.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        return ResponseEntity.ok(
                new CreateApplicationChapterResponsePayload(createdApplicationChapter.get().getApplicationChapterId().getId())
        );
    }

    @RequestMapping(value = "/chapter-management/application-chapter/{applicationChapterId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateApplicationChapter(@RequestHeader("Authorization") @NonNull String authorizationHeader,
                                                      @PathVariable @NonNull UUID applicationChapterId,
                                                      @RequestBody @NonNull UpdatePredefinedOrderNumberOfApplicationChapterRequestPayload payload)
            throws NoAuthorizationRestException {
        internalAuthorizationSystemAdapterForRestControllers.checkSystemClientAuthorization(authorizationHeader);

        log.info(LOG_PREFIX + "Update Application Chapter: \"{}\".", payload);
        Optional<ApplicationChapter> updatedApplicationChapter = applicationChapterUseCase.updateApplicationChapter(
                new UpdatePredefinedOrderNumberOfApplicationChapterCommand(
                        new ApplicationChapterId(applicationChapterId),
                        payload.getPredefinedOrderNumber()
                )
        );

        if (updatedApplicationChapter.isPresent()) {
            return ResponseEntity.ok().body(
                    new UpdatePredefinedOrderNumberOfApplicationChapterResponsePayload(
                            applicationChapterId,
                            payload.getPredefinedOrderNumber()
                    )
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/chapter-management/application-chapter/{applicationChapterId}/file/download-url", method = RequestMethod.GET)
    public ResponseEntity<?> getApplicationChapterFileDownloadUrl(@RequestHeader("Authorization") @NonNull String authorizationHeader,
                                                                  @PathVariable @NonNull UUID applicationChapterId)
            throws NoAuthorizationRestException {

        Optional<ApplicationChapter> applicationChapter = applicationChapterUseCase.getApplicationChapter(
                new GetApplicationChapterCommand(new ApplicationChapterId(applicationChapterId)));

        if (applicationChapter.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        internalAuthorizationSystemAdapterForRestControllers.checkAuthorizationForCompanyCode(authorizationHeader,
                applicationChapter.get().getCompanyCodeId().getId());

        log.info(LOG_PREFIX + "Get Presigned-Download URL for Application Chapter: \"{}\".", applicationChapterId);
        Optional<URL> presignedDownloadUrl = internalApplicationFilesManagementAdapter.getPresignedDownloadUrl(
                new ApplicationChapterId(applicationChapterId));

        if (presignedDownloadUrl.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        return ResponseEntity.ok(new GetPresignedUrlResponsePayload(presignedDownloadUrl.get()));
    }

    @RequestMapping(value = "/chapter-management/application-chapter/{applicationChapterId}/file/upload-url", method = RequestMethod.GET)
    public ResponseEntity<?> getApplicationChapterFileUploadUrl(@RequestHeader("Authorization") @NonNull String authorizationHeader,
                                                                @PathVariable @NonNull UUID applicationChapterId)
            throws NoAuthorizationRestException {
        internalAuthorizationSystemAdapterForRestControllers.checkSystemClientAuthorization(authorizationHeader);

        log.info(LOG_PREFIX + "Get Presigned-Upload URL for Application Chapter: \"{}\".", applicationChapterId);
        Optional<URL> presignedUploadUrl = internalApplicationFilesManagementAdapter.getPresignedUploadUrl(
                new ApplicationChapterId(applicationChapterId));

        if (presignedUploadUrl.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        return ResponseEntity.ok(new GetPresignedUrlResponsePayload(presignedUploadUrl.get()));
    }
}
