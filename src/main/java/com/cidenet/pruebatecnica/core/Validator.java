package com.cidenet.pruebatecnica.core;

import com.cidenet.pruebatecnica.exceptions.CidenetBadRequestException;
import com.cidenet.pruebatecnica.exceptions.ExceptionStatus;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.Objects;
import java.util.Optional;

public class Validator {

    private static final String uuidRegex =
            "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    public static void checkPatientId(final Optional<String> patientId) {
        patientId
                .filter(patId -> Validator.validId(patId))
                .orElseThrow(() -> new CidenetBadRequestException(ExceptionStatus.INVALID_PATIENT_ID));
    }

    public static void checkIdType(final String idType){
        if (!IdType.isAValidIdType(idType))
            throw new CidenetBadRequestException(ExceptionStatus.INVALID_ID_TYPE);
    }

    // Only numbers
    public static void checkIdNumber(final String idNumber) {
        String pattern = "[a-zA-Z0-9]{6,10}";

        if (!idNumber.matches(pattern)) {
            throw new CidenetBadRequestException(ExceptionStatus.INVALID_ID_NUMBER);
        }
    }

    public static void checkFirstName(final String firstName) {
        if (Objects.isNull(firstName) || firstName.isEmpty())
            throw new CidenetBadRequestException(ExceptionStatus.INVALID_FIRST_NAME);
    }

    public static void checkLastName(final String lastName) {
        if (Objects.isNull(lastName) || lastName.isEmpty())
            throw new CidenetBadRequestException(ExceptionStatus.INVALID_LAST_NAME);
    }

    // Valid Email
    public static void checkEmail(final String email) {
        EmailValidator validator = EmailValidator.getInstance();

        if (!validator.isValid(email)) throw new CidenetBadRequestException(ExceptionStatus.INVALID_EMAIL);
    }

    // Only Numbers
    public static void checkPhone(final String phone) {
        String pattern = "[0-9]+";

        if (!phone.matches(pattern)) {
            throw new CidenetBadRequestException(ExceptionStatus.INVALID_PHONE);
        }
    }


    public static boolean validId(final String id) {
        return id.matches(uuidRegex);
    }

}
