package com.ami.wechatmessage.enums;

public enum  ResEnum {
    SUCCESS("SUCCESS","发送成功"),
    FAILED("FAILED","发送失败"),
    ;

    private String code;
    private String message;

    ResEnum(String code, String message) {
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
