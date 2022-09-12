package com.ami.wechatmessage.enums;

public enum SendMessageEnum {
    GOOD_MORNING_MESSAGE("早上消息","GoodMorningSendMessageTemplate","1"),
    GOOD_NIGHT_MESSAGE("晚安消息","GoodNightSendMessageTemplate","2"),
    DRINK_WATER_MESSAGE("多喝水消息","DrinkWaterMessageTemplate","3")
    ;

    SendMessageEnum(String desc, String beanName, String template) {
        this.desc = desc;
        this.beanName = beanName;
        this.template = template;
    }

    private String desc;
    private String beanName;
    private String template;

    public String getDesc() {
        return desc;
    }

    public String getBeanName() {
        return beanName;
    }

    public String getTemplate() {
        return template;
    }
}
