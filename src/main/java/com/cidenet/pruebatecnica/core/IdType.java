package com.cidenet.pruebatecnica.core;

public enum IdType {
    CC("1"),
    CE("2");

    private String idTypeNumber;

    IdType(String idTypeNumber) {
        this.idTypeNumber = idTypeNumber;
    }

    public String getIdTypeNumber() {
        return idTypeNumber;
    }

    public static boolean isAValidIdType(String idType) {
        for (IdType elem : IdType.values()) {
            if (elem.name().equals(idType)) {
                return true;
            }
        }
        return false;
    }
}
