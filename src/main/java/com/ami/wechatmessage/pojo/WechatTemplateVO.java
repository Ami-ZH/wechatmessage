package com.ami.wechatmessage.pojo;

import lombok.Data;

@Data
public class WechatTemplateVO {
    public WechatTemplateVO(String value, String color) {
        this.value = value;
        this.color = color;
    }

    private String value;
    private String color;
}
