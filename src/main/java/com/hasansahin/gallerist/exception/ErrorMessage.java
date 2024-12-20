package com.hasansahin.gallerist.exception;

public class ErrorMessage {
    private String ofStatic;
    private MessageType messageType;

    public ErrorMessage(MessageType messageType,String ofStatic) {
        this.ofStatic = ofStatic;
        this.messageType = messageType;
    }

    public String getOfStatic() {
        return ofStatic;
    }

    public void setOfStatic(String ofStatic) {
        this.ofStatic = ofStatic;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String prepareErrorMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(messageType.getMessage());
        if (ofStatic != null) {
            builder.append(" : ").append(ofStatic);
        }
        return builder.toString();
    }
}
