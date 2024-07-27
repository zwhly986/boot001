package com.jd.boot001.common.exception;

import com.jd.boot001.common.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理，复合注解：
 * @ControllerAdvice
 * @ResponseBody
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public R bizExceptionHandler(BusinessException e) {
        return R.error(e.getErrorMsg());
    }

    /**
     * 处理其他异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R exceptionHandler(Exception e) {
        return R.error(e.getMessage());
    }

}
