package com.tmtc.annotation;

import java.lang.annotation.*;

/**
 * Created:  hbwhypw
 * Date: 2015/10/22 10:40
 * Function:
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {
    String value() default "";
}
