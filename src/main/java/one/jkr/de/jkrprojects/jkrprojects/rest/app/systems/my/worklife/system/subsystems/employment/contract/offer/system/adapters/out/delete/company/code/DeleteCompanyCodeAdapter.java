package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.adapters.out.delete.company.code;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.adapters.in.internal.InternalApplicationChapterManagementAdapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.application.chapter.management.domain.ApplicationChapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.adapters.in.internal.InternalCompanyCodeAdapter;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.company.code.controlling.domain.CompanyCodeId;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.application.ports.out.DeleteCompanyCodePort;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DeleteCompanyCodeAdapter implements DeleteCompanyCodePort {

    @NonNull
    private final InternalApplicationChapterManagementAdapter internalApplicationChapterManagementAdapter;

    @NonNull
    private final InternalCompanyCodeAdapter internalCompanyCodeAdapter;

    @Override
    public boolean deleteCompanyCode(@NonNull CompanyCodeId companyCodeId) {
        Set<ApplicationChapter> applicationChapters = internalApplicationChapterManagementAdapter.getApplicationChapters(companyCodeId);
        applicationChapters.forEach(applicationChapter ->
                internalApplicationChapterManagementAdapter.removeApplicationChapter(applicationChapter.getApplicationChapterId()));
        return internalCompanyCodeAdapter.removeCompanyCode(companyCodeId);
    }

}
