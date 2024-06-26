package top.wisely.tenancy.config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class TenantContext {
    private static final ThreadLocal<String> tenantId = new InheritableThreadLocal<>();

    public static void setTenantId(String tenant) {
        log.debug("Setting current tenant to {}", tenant);
        tenantId.set(tenant);
    }

    public static String getTenantId() {
        return tenantId.get();
    }

    public static void clear() {
        tenantId.remove();
    }

}