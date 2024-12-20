package com.hasansahin.gallerist.exception;

public enum MessageType {
    NO_RECORD_EXIST("1004","No record exist"),
    GENERAL_EXCEPTION("9999","General exception");

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
