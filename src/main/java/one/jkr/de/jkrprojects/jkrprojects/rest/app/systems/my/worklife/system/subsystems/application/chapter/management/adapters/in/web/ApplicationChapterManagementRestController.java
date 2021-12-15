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
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.create.CreateApplicationChapterCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.create.CreateApplicationChapterUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.get.GetAllApplicationChaptersForCompanyCodeCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.get.GetApplicationChapterCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.get.GetApplicationChapterUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.update.UpdateApplicationChapterUseCase;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.application.ports.in.update.UpdatePredefinedOrderNumberOfApplicationChapterCommand;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapterId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.subsystems.application.files.management.adapters.in.InternalIssuePresignedURLsForApplicationFilesManagementAdapter;
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

    private static final String LOG_PREFIX = "[Application Chapter Management REST-Controller]: ";

    @NonNull
    private final InternalAuthorizationSystemAdapterForRestControllers internalAuthorizationSystemAdapterForRestControllers;

    @NonNull
    private final InternalIssuePresignedURLsForApplicationFilesManagementAdapter internalIssuePresignedURLsForApplicationFilesManagementAdapter;

    @NonNull
    private final GetApplicationChapterUseCase getApplicationChapterUseCase;

    @NonNull
    private final CreateApplicationChapterUseCase createApplicationChapterUseCase;

    @NonNull
    private final UpdateApplicationChapterUseCase updateApplicationChapterUseCase;

    @RequestMapping(value = "/chapter-management/list-all/by-company-code-id/{companyCodeId}", method = RequestMethod.GET,
            consumes = "application/vnd.jkrsoftwarede.my-worklife.application-chapter-management-system.v1+json",
            produces = "application/vnd.jkrsoftwarede.my-worklife.application-chapter-management-system.v1+json")
    public ResponseEntity<?> listAllApplicationChaptersForCompanyCode(@RequestHeader("Authorization") @NonNull String authorizationHeader,
                                                                      @PathVariable @NonNull UUID companyCodeId)
            throws NoAuthorizationRestException {
        internalAuthorizationSystemAdapterForRestControllers.checkAuthorizationForCompanyCode(authorizationHeader, companyCodeId);

        log.info(LOG_PREFIX + "List all Application Chapters for CompanyCode: \"{}\".", companyCodeId);
        Set<ApplicationChapter> applicationChapters = getApplicationChapterUseCase.getApplicationChapters(
                new GetAllApplicationChaptersForCompanyCodeCommand(new CompanyCodeId(companyCodeId))
        );

        if (applicationChapters.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(new ListAllApplicationChaptersForCompanyCodeResponsePayload(applicationChapters));
    }

    @RequestMapping(value = "/chapter-management/application-chapter", method = RequestMethod.POST,
            consumes = "application/vnd.jkrsoftwarede.my-worklife.application-chapter-management-system.v1+json",
            produces = "application/vnd.jkrsoftwarede.my-worklife.application-chapter-management-system.v1+json")
    public ResponseEntity<?> createNewApplicationChapter(
            @RequestHeader("Authorization") @NonNull String authorizationHeader,
            @RequestBody @NonNull CreateApplicationChapterRequestPayload payload) throws NoAuthorizationRestException {
        internalAuthorizationSystemAdapterForRestControllers.checkSystemClientAuthorization(authorizationHeader);

        log.info(LOG_PREFIX + "Create Application Chapter: \"{}\".", payload);
        Optional<ApplicationChapter> createdApplicationChapter = createApplicationChapterUseCase.createApplicationChapter(
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

    @RequestMapping(value = "/chapter-management/application-chapter/{applicationChapterId}", method = RequestMethod.PUT,
            consumes = "application/vnd.jkrsoftwarede.my-worklife.application-chapter-management-system.v1+json",
            produces = "application/vnd.jkrsoftwarede.my-worklife.application-chapter-management-system.v1+json")
    public ResponseEntity<?> updateApplicationChapter(@RequestHeader("Authorization") @NonNull String authorizationHeader,
                                                      @PathVariable @NonNull UUID applicationChapterId,
                                                      @RequestBody @NonNull UpdatePredefinedOrderNumberOfApplicationChapterRequestPayload payload)
            throws NoAuthorizationRestException {
        internalAuthorizationSystemAdapterForRestControllers.checkSystemClientAuthorization(authorizationHeader);

        log.info(LOG_PREFIX + "Update Application Chapter: \"{}\".", payload);
        Optional<ApplicationChapter> updatedApplicationChapter = updateApplicationChapterUseCase.updateApplicationChapter(
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

    @RequestMapping(value = "/chapter-management/application-chapter/{applicationChapterId}/file/download-url", method = RequestMethod.GET,
            consumes = "application/vnd.jkrsoftwarede.my-worklife.application-chapter-management-system.v1+json",
            produces = "application/vnd.jkrsoftwarede.my-worklife.application-chapter-management-system.v1+json")
    public ResponseEntity<?> getApplicationChapterFileDownloadUrl(@RequestHeader("Authorization") @NonNull String authorizationHeader,
                                                                  @PathVariable @NonNull UUID applicationChapterId)
            throws NoAuthorizationRestException {
        Optional<ApplicationChapter> applicationChapter = getApplicationChapterUseCase.getApplicationChapter(
                new GetApplicationChapterCommand(new ApplicationChapterId(applicationChapterId)));
        if (applicationChapter.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        internalAuthorizationSystemAdapterForRestControllers.checkAuthorizationForCompanyCode(
                authorizationHeader, applicationChapter.get().getCompanyCodeId().getId()
        );

        log.info(LOG_PREFIX + "Get Presigned-Download URL for Application Chapter: \"{}\".", applicationChapterId);
        Optional<URL> presignedDownloadUrl = internalIssuePresignedURLsForApplicationFilesManagementAdapter.getPresignedDownloadUrl(
                new ApplicationChapterId(applicationChapterId));

        if (presignedDownloadUrl.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        return ResponseEntity.ok(new GetPresignedUrlResponsePayload(presignedDownloadUrl.get()));
    }

    @RequestMapping(value = "/chapter-management/application-chapter/{applicationChapterId}/file/upload-url", method = RequestMethod.GET,
            consumes = "application/vnd.jkrsoftwarede.my-worklife.application-chapter-management-system.v1+json",
            produces = "application/vnd.jkrsoftwarede.my-worklife.application-chapter-management-system.v1+json")
    public ResponseEntity<?> getApplicationChapterFileUploadUrl(@RequestHeader("Authorization") @NonNull String authorizationHeader,
                                                                @PathVariable @NonNull UUID applicationChapterId)
            throws NoAuthorizationRestException {
        internalAuthorizationSystemAdapterForRestControllers.checkSystemClientAuthorization(authorizationHeader);

        log.info(LOG_PREFIX + "Get Presigned-Upload URL for Application Chapter: \"{}\".", applicationChapterId);
        Optional<URL> presignedUploadUrl = internalIssuePresignedURLsForApplicationFilesManagementAdapter.getPresignedUploadUrl(
                new ApplicationChapterId(applicationChapterId));

        if (presignedUploadUrl.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        return ResponseEntity.ok(new GetPresignedUrlResponsePayload(presignedUploadUrl.get()));
    }
}
