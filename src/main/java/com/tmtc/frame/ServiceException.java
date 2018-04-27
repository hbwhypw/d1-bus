package com.tmtc.frame;

/**
 * @author Administrator
 */
public class ServiceException extends Exception {

    private static final long serialVersionUID = -6823184868331282109L;
    private ExceptionEnum exceptionEnum;

    public ServiceException() {
        super();
    }

    public ServiceException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public void setExceptionEnum(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }
}
