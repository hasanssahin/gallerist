package com.hasansahin.gallerist.exception;

public enum MessageType {
    NO_RECORD_EXIST("1004","No record exist"),
    GENERAL_EXCEPTION("9999","General exception"),
    TOKEN_IS_EXPIRED("1005","Token is expired"),
    USERNAME_NOT_FOUND("1006","Username not found"),
    USERNAME_OR_PASSWORD_INVALID("1007","Username or password is wrong");

    private String code;
    private String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
