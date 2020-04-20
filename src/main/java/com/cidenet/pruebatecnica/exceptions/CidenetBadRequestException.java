package com.cidenet.pruebatecnica.exceptions;

public class CidenetBadRequestException extends BaseException {

    public CidenetBadRequestException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus, 400);
    }
}
