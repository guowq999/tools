package com.owen.common.util;

import com.owen.common.core.log.LOG;
import com.owen.common.filter.BodyReaderHttpServletRequestWrapper;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wenqiang
 * @date 2023/09/16 13:27
 **/
public class ReqUtil {
    private static final String FORMAT_HEADER = "-H \"%1$s:%2$s\"";
    private static final String FORMAT_METHOD = "-X %1$s";
    private static final String FORMAT_BODY = "-d '%1$s'";
    private static final String FORMAT_URL = "\"%1$s\"";

    private static final List<String> BLACK_HEADERS = Arrays.asList("content-length", "host", "connection", "accept-encoding", "accept");

    /**
     * <p>
     * HttpServletRequest 转化为 CURL 命令
     * </p>
     *
     * @param request request
     * @return String
     * @author Tophua
     * @since 2021/8/19
     */
    public static String getCurl(HttpServletRequest request) {
        String curl;
        try {
            List<String> parts = new ArrayList<>();
            parts.add("curl");
            String url = request.getRequestURL().toString();
            String method = request.getMethod();
            String contentType = request.getContentType();
            if (contentType == null) {
                contentType = "";
            }
            String queryString = request.getQueryString();
            parts.add(String.format(FORMAT_METHOD, method.toUpperCase()));

            Map<String, String> headers = new HashMap<>(16);
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String key = headerNames.nextElement();
                if (BLACK_HEADERS.contains(key)) {
                    continue;
                }
                headers.put(key, request.getHeader(key));
            }
            headers.forEach((k, v) -> parts.add(String.format(FORMAT_HEADER, k, v)));
            if (StringUtils.isNotEmpty(queryString)) {
                url = url + "?" + queryString;
            }
            if (contentType.contains("www-form") && request.getParameterMap() != null) {
                request.getParameterMap().forEach((k, v) ->
                        parts.add(String.format("--data-urlencode '%s=%s'", k, v[0])));
            }
            if (contentType.contains("json")) {
                BodyReaderHttpServletRequestWrapper wrapper = (BodyReaderHttpServletRequestWrapper) request;
                String body = IOUtils.toString(wrapper.getInputStream(), StandardCharsets.UTF_8);
                if (StringUtils.isNotEmpty(body)) {
                    parts.add(String.format(FORMAT_BODY, body));
                }
            }
            parts.add(String.format(FORMAT_URL, url));
            curl = String.join(" ", parts);
        } catch (Exception e) {
            LOG.warn("getCurl", e);
            curl = null;
        }
        return curl;
    }


    public static String getQuery(HttpServletRequest request) {
        Map<String, String[]> paramMap = request.getParameterMap();
        if (paramMap != null && !paramMap.isEmpty()) {
            Map<String, Object> retMap = new LinkedHashMap<>(paramMap.size() * 2);
            Set<Map.Entry<String, String[]>> entrySet = paramMap.entrySet();

            for (Map.Entry<String, String[]> entry : entrySet) {
                String name = entry.getKey();
                String[] values = entry.getValue();
                if (values.length == 1) {
                    retMap.put(name, values[0]);
                } else {
                    retMap.put(name, values);
                }
            }
            return retMap.entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + "=" + entry.getValue())
                    .collect(Collectors.joining("&"));
        } else {
            return "";
        }
    }
    public static String getHeaders(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        StringBuilder sb = new StringBuilder();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            sb.append(key).append(":").append(request.getHeader(key)).append("\n");
        }
        return sb.toString();
    }

    public static String getBody(HttpServletRequest request) {
        try {
            return IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            LOG.error("get body error", e);
            return "";
        }
    }
}