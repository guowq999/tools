package com.owen.common.core.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LOG {

    private static final Map<String, Logger> LOGGER_MAP = new ConcurrentHashMap<>(64);

    public static void error(String msg) {
        getLogger(getClassName()).error(msg);
    }

    public static void error(String msg, Object... obj) {
        getLogger(getClassName()).error(msg, obj);
    }

    public static void warn(String msg) {
        getLogger(getClassName()).warn(msg);
    }

    public static void warn(String msg, Object... obj) {
        getLogger(getClassName()).warn(msg, obj);
    }

    public static void info(String msg) {
        getLogger(getClassName()).info(msg);
    }

    public static void info(String msg, Object... obj) {
        getLogger(getClassName()).info(msg, obj);
    }

    public static void debug(String msg) {
        getLogger(getClassName()).debug(msg);
    }

    public static void debug(String msg, Object... obj) {
        getLogger(getClassName()).debug(msg, obj);
    }

    private static Logger getLogger(String className) {
        return LOGGER_MAP.computeIfAbsent(className, LoggerFactory::getLogger);
    }

    // 获取调用 error,info,debug静态类的类名
    private static String getClassName() {
        return new SecurityManager() {
            public String getClassName() {
                return getClassContext()[3].getName();
            }
        }.getClassName();
    }
}