package top.wisely.tenancy.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.TenantId;
import top.wisely.tenancy.config.TextEncryptorConverter;

@Entity
@Data
/*@FilterDef(
        name="tenancy-filter",
        defaultCondition = "tenant_id = :tenantId",
        autoEnabled=true,
        parameters = @ParamDef(
                name="tenantId",
                type=String.class
        )
)
@Filter(name="tenancy-filter")*/
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @TenantId
    private String tenantId;

    private String name;

    private Integer age;

    @Convert(converter = TextEncryptorConverter.class)
    private String email;
}
