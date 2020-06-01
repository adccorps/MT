package com.mt.exception;


import com.mt.constants.Code;
import com.mt.pojo.Result;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



/**
 * 自定义异常处理器
 * @author ieflex
 */
//@RestControllerAdvice 是组件注解，他使得其实现类能够被classpath扫描自动发现
// 如果应用是通过MVC命令空间或MVC Java编程方式配置，那么该特性默认是自动开启的。
@RestControllerAdvice
public class ResultExceptionHandler {
    protected static Logger log = LoggerFactory.getLogger(ResultException.class);
    /**
     * 拦截所有运行时的全局异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result runtimeException(ResultException e) {
        log.error(e.getMessage(), e);
        Result result = new Result(e.getCode());
        return result;
    }
    /**
     * 捕捉shiro的异常
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public Result handle401(ShiroException e) {
        log.error(e.getMessage(), e);
        return new Result(Code.UNAUTHORIZED);
    }

    /**
     * 捕捉UnauthorizedException
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public Result handle401() {
        return  new Result(Code.UNAUTHORIZED);
    }
    /**
     * 系统异常捕获处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exception(ResultException e) {
        log.error(e.getMessage(), e);
        Result result = new Result(e.getCode());
        return result;
    }
}
