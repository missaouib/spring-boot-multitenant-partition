package top.wisely.tenancy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.TenantId;

@Getter
@Setter
@MappedSuperclass
public abstract class TenantAwareEntity {
    @TenantId
    @Column(name = "tenant_id")
    private String tenantId;
}