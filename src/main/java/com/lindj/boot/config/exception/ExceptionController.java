package com.lindj.boot.config.exception;

import com.lindj.boot.util.BusinessException;
import com.lindj.boot.util.ResponseBean;
import org.apache.shiro.ShiroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lindj
 * @date 2019/5/30 0030
 * @description
 */
@RestControllerAdvice
public class ExceptionController {

    private Logger logger = LoggerFactory.getLogger(ExceptionController.class);

/*    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public ResponseBean handle401(ShiroException e) {
        return new ResponseBean(401, e.getMessage(), null);
    }*/

/*    // 捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BusinessException.class)
    public ResponseBean handle401() {
        return new ResponseBean(401, "Unauthorized", null);
    }*/

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseBean globalException(HttpServletRequest request, Throwable ex) {
        if(ex instanceof ShiroException){
            return new ResponseBean(HttpStatus.UNAUTHORIZED.value(), "Unauthorized", null);
        }
        else if(ex instanceof BusinessException){
            return new ResponseBean(HttpStatus.UNAUTHORIZED.value(), ex.getMessage(), null);
        }
        ex.printStackTrace();
        logger.error("{}", ex.getMessage());
        return new ResponseBean(getStatus(request).value(), ex.getMessage(), null);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
