package com.cidenet.pruebatecnica.exceptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum ExceptionStatus {
    INVALID_PATIENT_ID("001", "The patient ID is invalid"),
    INVALID_ID_TYPE("002", "The ID type is invalid"),
    INVALID_ID_NUMBER("003", "The number ID is invalid"),
    INVALID_FIRST_NAME("004", "The first name is invalid"),
    INVALID_LAST_NAME("005", "The last name is invalid"),
    INVALID_EMAIL("006", "Invalid email"),
    INVALID_PHONE("007",  "Invalid phone"),
    NOT_FOUND_PATIENT("009", "Patient not found"),
    ERROR_CREATING_PATIENT("010", "Unable to create patient");

    private final String code;
    private final String message;
    private static final Map<String, String> exceptionMap =
            Collections.unmodifiableMap(initializeMapping());

    ExceptionStatus(String code, final String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ExceptionStatus get(String code) {
        for (ExceptionStatus v : values()) if (v.getCode() == code) return v;

        throw new IllegalArgumentException();
    }

    private static Map<String, String> initializeMapping() {
        Map<String, String> mMap = new HashMap<>();
        for (ExceptionStatus s : ExceptionStatus.values()) {
            mMap.put(s.code, s.message);
        }
        return mMap;
    }
}

