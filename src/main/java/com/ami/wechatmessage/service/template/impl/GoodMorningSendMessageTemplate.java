package com.ami.wechatmessage.service.template.impl;

import com.ami.wechatmessage.config.TianXingConfig;
import com.ami.wechatmessage.config.WechatConfig;
import com.ami.wechatmessage.enums.ColorEnum;
import com.ami.wechatmessage.pojo.WechatTemplateVO;
import com.ami.wechatmessage.pojo.message.WeChatSendMessageTemplateDTO;
import com.ami.wechatmessage.pojo.message.GoodMorningMessageBodyDTO;
import com.ami.wechatmessage.pojo.tianxing.WeatherInfoDTO;
import com.ami.wechatmessage.service.gateway.TianXingGatewayApiService;
import com.ami.wechatmessage.service.gateway.WechatGateWayService;
import com.ami.wechatmessage.service.template.AbstractSendMessageTemplate;
import org.springframework.stereotype.Service;

/**
 * 早安模板消息封装实现类
 *
 */
@Service("GoodMorningSendMessageTemplate")
public class GoodMorningSendMessageTemplate extends AbstractSendMessageTemplate {

    private final TianXingGatewayApiService tianXingGatewayApiService;

    public GoodMorningSendMessageTemplate(TianXingConfig tianXingConfig, WechatConfig wechatConfig,
                                          WechatGateWayService wechatGateWayService,
                                          TianXingGatewayApiService tianXingGatewayApiService) {
        super(tianXingConfig, wechatConfig, wechatGateWayService);
        this.tianXingGatewayApiService = tianXingGatewayApiService;
    }

    @Override
    protected WeChatSendMessageTemplateDTO setMessageBody(String templateId, String openId) {
        //获取早安语句
        String morningInfo = tianXingGatewayApiService.getGoodMorningInfo(tianXingConfig.getKey());
        GoodMorningMessageBodyDTO messageBody = new GoodMorningMessageBodyDTO();
        messageBody.setMorning(new WechatTemplateVO("Good morning~ "+ morningInfo, ColorEnum.RED.getColor()));
        //获取天气
        WeatherInfoDTO weatherInfoDTO = tianXingGatewayApiService.getWeatherInfo(tianXingConfig.getKey(),tianXingConfig.getArea());
        //日期
        messageBody.setDate(new WechatTemplateVO(weatherInfoDTO.getDate(),null));
        //星期
        messageBody.setWeek(new WechatTemplateVO(weatherInfoDTO.getWeek(),null));
        //城市
        messageBody.setCity(new WechatTemplateVO(weatherInfoDTO.getArea(), ColorEnum.PURPLE.getColor()));
        //天气
        messageBody.setWeather(new WechatTemplateVO(weatherInfoDTO.getWeather(), ColorEnum.BROWN.getColor()));
        //最低气温
        messageBody.setLowest(new WechatTemplateVO(weatherInfoDTO.getLowest(), ColorEnum.BLUE.getColor()));
        //最高气温
        messageBody.setHighest(new WechatTemplateVO(weatherInfoDTO.getHighest(), ColorEnum.DARK_RED.getColor()));
        //降水概率
        messageBody.setPop(new WechatTemplateVO(weatherInfoDTO.getPop()+"%", ColorEnum.BLUE.getColor()));
        //今日建议
        messageBody.setTips(new WechatTemplateVO(weatherInfoDTO.getTips(), ColorEnum.ORANGE.getColor()));
        //彩虹屁
        String caiHongPiInfo = tianXingGatewayApiService.getCaiHongPiInfo(tianXingConfig.getKey());
        messageBody.setPipi(new WechatTemplateVO(caiHongPiInfo, ColorEnum.LAVENDER.getColor()));

        //发送消息实体
        WeChatSendMessageTemplateDTO message = new WeChatSendMessageTemplateDTO();
        //设置模板id
        message.setTemplate_id(templateId);
        //设置接收用户
        message.setTouser(openId);
        message.setData(messageBody);

        return message;
    }

    @Override
    protected WeChatSendMessageTemplateDTO setMessageBodyToSpecial() {
        return null;
    }

    @Override
    protected String getTemplateId() {
        return wechatConfig.getGoodMorningTemplate();
    }
}
