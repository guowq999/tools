package com.owen.common.constants;

/**
 * @author wenqiang
 * @date 2023/9/15 12:18
 */
public interface CacheConstants {
    String REDIS_PREFIX = "project:app:";

    String LOCK_STOCK_IDEMPOTENT_CHECK = REDIS_PREFIX + "lock:stock:{0}:{1}";
}
