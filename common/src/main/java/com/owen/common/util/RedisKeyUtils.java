package com.owen.common.util;

import com.owen.common.context.TenantContext;

import java.text.MessageFormat;

import static com.owen.common.constants.CacheConstants.LOCK_STOCK_IDEMPOTENT_CHECK;

/**
 * @author wenqiang
 * @date 2023/09/15 12:19
 **/
public class RedisKeyUtils {
    /**
     * getLockStockKey 【方式一，key格式放在一个接口，这里赋值】 【默认加租户的】
     */
    public static String getLockStockKey(String documentNumber) {
        return MessageFormat.format(LOCK_STOCK_IDEMPOTENT_CHECK, TenantContext.getTenantId(), documentNumber);
    }

    /**
     * getPersonalWarehouseKey. 【方式二：直接在这里配置格式】
     */
    public static String getPersonalWarehouseKey(long warehouseId) {
        return String.format("personal_warehouse:%d", warehouseId);
    }
}