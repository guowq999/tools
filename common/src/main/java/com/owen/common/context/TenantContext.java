package com.owen.common.context;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author wenqiang
 * @date 2023/09/15 12:22
 **/
public class TenantContext {

    private static final ThreadLocal<Long> TENANT_LOCAL = new TransmittableThreadLocal<>();

    public static void setTenantId(Long tenantId) {
        TENANT_LOCAL.set(tenantId);
    }

    public static Long getTenantId() {
        return TENANT_LOCAL.get();
    }

    public static void remove() {
        TENANT_LOCAL.remove();
    }

}