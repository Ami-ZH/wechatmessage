package com.ami.wechatmessage.service.gateway;

import com.ami.wechatmessage.pojo.tianxing.WeatherInfoDTO;

public interface TianXingGatewayApiService {

    String getGoodMorningInfo(String key);

    WeatherInfoDTO getWeatherInfo(String key, String area);

    String getCaiHongPiInfo(String key);
}
