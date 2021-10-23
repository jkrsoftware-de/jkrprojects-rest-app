package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.application.chapter.management.adapters.out.application.chapter.persistence.entity.classes;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;

@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
@Entity
@Table(name = "APPLICATION_CHAPTERS")
public class ApplicationChapterDto {

    @NonNull
    @Id
    UUID applicationChapterId;

    @NonNull
    UUID companyCodeId;

    @NonNull
    String applicationChapterName;

    int predefinedOrderNumber;

    @NonNull
    @CreationTimestamp
    OffsetDateTime createdAt;

    @NonNull
    @LastModifiedDate
    OffsetDateTime lastModified;

}
