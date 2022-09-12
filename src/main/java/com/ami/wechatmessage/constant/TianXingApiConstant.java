package com.ami.wechatmessage.constant;

public interface TianXingApiConstant {

    String CONTENT_TYPE = "application/x-www-form-urlencoded";

    // 早安心语
    String ZAOAN_XINYU = "http://api.tianapi.com/zaoan/index?key=%s";
    // 天气预报
    String WEATHER_INFO = "http://api.tianapi.com/tianqi/index?key=%s&city=%s";

    //彩虹屁接口
    String CAI_HONG_API = "http://api.tianapi.com/caihongpi/index?key=%s";
}
