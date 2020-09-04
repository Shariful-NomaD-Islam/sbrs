package com.nomad.app.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Error List", description = "Possible error for the application.")
public enum ErrorDetails {
    NONE(0),
    GENERAL_ERROR(1099),
    PATH_NOT_EXISTS(1001),
    REQUEST_ERROR(1002),
    JASPER_ERROR(1003),
    CREATE_ARCHIEVE_ERROR(1004),
    BOOK_ID_NOT_FOUND(1101),
    ;

    private int value;

    ErrorDetails(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

