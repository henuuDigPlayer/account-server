package com.lindj.boot.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lindj
 * @date 2019/6/10 0010
 * @description
 */
public class RequestHolder {

    /**
     * 获取HttpServletRequest
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        return request;
    }


    /**
     * 获取token
     *
     * @return String
     */
    public static String getToken() {
        return getHeader(SecurityConsts.REQUEST_AUTH_HEADER);
    }



    /**
     * 获取请求头信息
     *
     * @param key String
     * @return String
     */
    public static String getHeader(String key) {
        return getRequest().getHeader(key);
    }
}
