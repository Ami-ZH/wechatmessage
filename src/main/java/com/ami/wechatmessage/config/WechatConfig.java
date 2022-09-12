package com.ami.wechatmessage.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class WechatConfig {

    @Value("${wechat.appId}")
    private String appId;
    @Value("${wechat.appSecret}")
    private String appSecert;
    @Value("${wechat.goodMornindTemplate}")
    private String goodMorningTemplate;

}
