package com.ami.wechatmessage.service.gateway.impl;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.ami.wechatmessage.constant.TianXingApiConstant;
import com.ami.wechatmessage.pojo.tianxing.CaiHongPiInfoDTO;
import com.ami.wechatmessage.pojo.tianxing.TianXingUnifiedsResDTO;
import com.ami.wechatmessage.pojo.tianxing.WeatherInfoDTO;
import com.ami.wechatmessage.pojo.tianxing.ZaoAnInfoDTO;
import com.ami.wechatmessage.service.gateway.TianXingGatewayApiService;
import org.springframework.stereotype.Service;


@Service
public class TianXingGatewayServiceImpl implements TianXingGatewayApiService {

    @Override
    public String getGoodMorningInfo(String key) {
        String requestUrl = String.format(TianXingApiConstant.ZAOAN_XINYU,key);
        String res = HttpUtil.createGet(requestUrl).contentType(TianXingApiConstant.CONTENT_TYPE).execute().body();
        TianXingUnifiedsResDTO<ZaoAnInfoDTO> resDTO = JSONUtil.toBean(res, new TypeReference<TianXingUnifiedsResDTO<ZaoAnInfoDTO>>() {},false);
        String content = resDTO.getNewslist().stream().findFirst().get().getContent();
        return content;
    }

    @Override
    public WeatherInfoDTO getWeatherInfo(String key, String area) {
        String requestUrl = String.format(TianXingApiConstant.WEATHER_INFO,key,area);
        String res = HttpUtil.createGet(requestUrl).contentType(TianXingApiConstant.CONTENT_TYPE).execute().body();
        TianXingUnifiedsResDTO<WeatherInfoDTO> resDTO = JSONUtil.toBean(res,new TypeReference<TianXingUnifiedsResDTO<WeatherInfoDTO>>() {},false);
        WeatherInfoDTO weatherInfoDTO = resDTO.getNewslist().stream().findFirst().get();
        return weatherInfoDTO;
    }

    @Override
    public String getCaiHongPiInfo(String key) {
        String requestUrl = String.format(TianXingApiConstant.CAI_HONG_API,key);
        String res = HttpUtil.createGet(requestUrl).contentType(TianXingApiConstant.CONTENT_TYPE).execute().body();
        TianXingUnifiedsResDTO<CaiHongPiInfoDTO> resDTO = JSONUtil.toBean(res, new TypeReference<TianXingUnifiedsResDTO<CaiHongPiInfoDTO>>() {},false);
        String content = resDTO.getNewslist().stream().findFirst().get().getContent();
        return content;
    }
}
