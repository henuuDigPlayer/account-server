package com.lindj.boot.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

/**
 * @author lindj
 * @date 2019/6/10 0010
 * @description
 */
public class ResponseHolder {

    /**
     * 获取HttpServletResponse
     *
     * @return HttpServletResponse
     */
    public static HttpServletResponse getResponse() {
        HttpServletResponse response =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }
}
