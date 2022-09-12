package com.ami.wechatmessage.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class TianXingConfig {

    @Value("${tianxing.key}")
    private String key;

    @Value("${tianxing.area}")
    private String area;
}
