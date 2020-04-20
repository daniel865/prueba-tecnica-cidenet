package com.cidenet.pruebatecnica.exceptions;

import java.util.Optional;

public abstract class BaseException extends RuntimeException {

    static final long serialVersionUID = -7034897190745761234L;
    private final ExceptionStatus exceptionStatus;
    private final Optional<Integer> httpStatusCode;

    public BaseException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
        this.exceptionStatus = exceptionStatus;
        this.httpStatusCode = Optional.empty();
    }

    public BaseException(ExceptionStatus exceptionStatus, int httpStatusCode) {
        super(exceptionStatus.getMessage());
        this.exceptionStatus = exceptionStatus;
        this.httpStatusCode = Optional.of(httpStatusCode);
    }

    public BaseException(ExceptionStatus exceptionStatus, final Throwable e) {
        super(e);
        this.exceptionStatus = exceptionStatus;
        this.httpStatusCode = Optional.empty();
    }

    public BaseException(ExceptionStatus exceptionStatus, int httpStatusCode, final Throwable e) {
        super(e);
        this.exceptionStatus = exceptionStatus;
        this.httpStatusCode = Optional.of(httpStatusCode);
    }

    public String getCode() {
        return exceptionStatus.getCode();
    }

    public String getAddiMessage() {
        return exceptionStatus.getMessage();
    }

    public int getHttpStatusCode() {
        return httpStatusCode.orElse(0);
    }

}
