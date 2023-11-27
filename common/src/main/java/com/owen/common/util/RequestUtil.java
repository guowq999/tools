package com.owen.common.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author wenqiang
 * @date 2023/09/16 11:11
 **/
public class RequestUtil {
    private static final String IP_UNKNOWN = "unknown";
    private static final String IP_LOCAL = "127.0.0.1";
    private static final int IP_LEN = 15;
    private static final String IP_SPLIT = ",";

    public RequestUtil() {
    }

    public static Map<String, String> getFormFields(HttpServletRequest request) {
        String query;
        try {
            ServletInputStream inputStream = request.getInputStream();
            query = IOUtils.toString(inputStream, request.getCharacterEncoding());
        } catch (IOException var3) {
            throw new RuntimeException("请求失败");
        }

        return parseQueryString(query);
    }

    public static Map<String, String> getRequestParamsToMap(HttpServletRequest request) {
        Map<String, String[]> paramMap = request.getParameterMap();
        if (paramMap != null && !paramMap.isEmpty()) {
            Map<String, String> retMap = new HashMap(paramMap.size() * 2);
            Set<Map.Entry<String, String[]>> entrySet = paramMap.entrySet();
            Iterator var4 = entrySet.iterator();

            while(var4.hasNext()) {
                Map.Entry<String, String[]> entry = (Map.Entry)var4.next();
                String name = (String)entry.getKey();
                String[] values = (String[])entry.getValue();
                if (values.length >= 1) {
                    retMap.put(name, values[0]);
                } else {
                    retMap.put(name, "");
                }
            }

            return retMap;
        } else {
            return Collections.emptyMap();
        }
    }

    public static Map<String, Object> getJsonObject(HttpServletRequest request) {
        String json = getText(request);
        return (Map)(StringUtils.isEmpty(json) ? Collections.emptyMap() : JSON.parseObject(json));
    }

    private static String getText(HttpServletRequest request) {
        try {
            ServletInputStream inputStream = request.getInputStream();
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException var2) {
            var2.printStackTrace();
            return "";
        }
    }

    public static Map<String, String> parseQueryString(String query) {
        if (StringUtils.isEmpty(query)) {
            return Collections.emptyMap();
        } else {
            query = StringUtils.trimLeadingCharacter(query, '?');
            String[] pairs = query.split("&");
            Map<String, String> form = new HashMap(pairs.length * 2);
            String[] var3 = pairs;
            int var4 = pairs.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String pair = var3[var5];
                String[] param = pair.split("=");
                String key = param[0];
                String value = param[1];

                try {
                    value = URLDecoder.decode(value, "UTF-8");
                } catch (UnsupportedEncodingException var11) {
                    var11.printStackTrace();
                }

                form.put(key, value);
            }

            return form;
        }
    }

    public static Map<String, String> getMultipartFields(HttpServletRequest request) {
        Map<String, String> queryParams = parseQueryString(request.getQueryString());
        Map<String, String> uploadParams = new HashMap(16);
        Set<String> queryKeys = queryParams.keySet();
        request.getParameterMap().forEach((key, value) -> {
            if (!queryKeys.contains(key)) {
                uploadParams.put(key, value[0]);
            }

        });
        return uploadParams;
    }

    public static String getIp(HttpServletRequest request) {
        return resolveRealIp(request);
    }

    public static String resolveRealIp(HttpServletRequest request) {
        String realIp = "unknown";
        if (null == request) {
            return realIp;
        } else {
            realIp = request.getHeader("X-Forwarded-For");
            if (StringUtils.hasText(realIp) && !"unknown".equalsIgnoreCase(realIp)) {
                int index = realIp.indexOf(",");
                return index != -1 ? realIp.substring(0, index) : realIp;
            } else {
                realIp = request.getHeader("X-Real-IP");
                if (StringUtils.hasText(realIp) && !"unknown".equalsIgnoreCase(realIp)) {
                    return realIp;
                } else {
                    realIp = request.getHeader("Proxy-Client-IP");
                    if (StringUtils.hasText(realIp) && !"unknown".equalsIgnoreCase(realIp)) {
                        return realIp;
                    } else {
                        realIp = request.getHeader("WL-Proxy-Client-IP");
                        if (StringUtils.hasText(realIp) && !"unknown".equalsIgnoreCase(realIp)) {
                            return realIp;
                        } else {
                            realIp = request.getHeader("HTTP_CLIENT_IP");
                            if (StringUtils.hasText(realIp) && !"unknown".equalsIgnoreCase(realIp)) {
                                return realIp;
                            } else {
                                realIp = request.getRemoteAddr();
                                if (StringUtils.hasText(realIp)) {
                                    return realIp;
                                } else {
                                    throw new IllegalStateException("获取IP地址失败，这种情况不应该发生！");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestedWith = request.getHeader("x-requested-with");
        return "XMLHttpRequest".equalsIgnoreCase(requestedWith);
    }
}