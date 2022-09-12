package com.ami.wechatmessage.enums;

public enum SpecialOpenIdEnum {
    MY_SELF("",""),

    ;
    private String OpenId;
    private String city;

    SpecialOpenIdEnum(String openId, String city) {
        OpenId = openId;
        this.city = city;
    }

    public String getOpenId() {
        return OpenId;
    }

    public String getCity() {
        return city;
    }
}
