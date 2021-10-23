package one.jkr.de.jkrprojects.jkrprojects.rest.app.my.worklife.system.subsystems.company.code.controlling.adapters.out.company.code.persistence.entity.classes;

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
@Table(name = "COMPANY_CODES")
public class CompanyCodeDto {

    @NonNull
    @Id
    UUID companyCodeId;

    @NonNull
    String companyCode;

    @NonNull
    @CreationTimestamp
    OffsetDateTime createdAt;

    @NonNull
    @LastModifiedDate
    OffsetDateTime lastModified;

}
