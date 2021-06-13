package com.mkamalova.readingisgood.util;
import com.mkamalova.readingisgood.enumaration.EnumResponseMessage;

public class ReadingIsGoodException extends  RuntimeException {

    public final EnumResponseMessage enumResponseMessage;

    public ReadingIsGoodException(String message) {
        super(message);
        this.enumResponseMessage = EnumResponseMessage.RC_ERROR;
    }
    public ReadingIsGoodException(String message, Throwable cause){
        super(message,cause);
        this.enumResponseMessage = EnumResponseMessage.RC_ERROR;
    }
    public ReadingIsGoodException(String message, EnumResponseMessage responseCode){
        super(message);
        this.enumResponseMessage = responseCode;
    }

    public EnumResponseMessage getEnumResponseMessage() {
        return enumResponseMessage;
    }
}
