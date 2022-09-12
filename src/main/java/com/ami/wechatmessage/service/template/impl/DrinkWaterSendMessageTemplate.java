package com.ami.wechatmessage.service.template.impl;

import com.ami.wechatmessage.config.TianXingConfig;
import com.ami.wechatmessage.config.WechatConfig;
import com.ami.wechatmessage.pojo.message.WeChatSendMessageTemplateDTO;
import com.ami.wechatmessage.service.gateway.WechatGateWayService;
import com.ami.wechatmessage.service.template.AbstractSendMessageTemplate;
import org.springframework.stereotype.Service;

/**
 * 喝水提醒消息模板
 */
@Service("DrinkWaterMessageTemplate")
public class DrinkWaterSendMessageTemplate extends AbstractSendMessageTemplate {

    public DrinkWaterSendMessageTemplate(TianXingConfig tianXingConfig, WechatConfig wechatConfig,
                                         WechatGateWayService wechatGateWayService) {
        super(tianXingConfig, wechatConfig, wechatGateWayService);
    }

    @Override
    protected WeChatSendMessageTemplateDTO setMessageBody(String templateId, String openId) {
        return null;
    }

    @Override
    protected WeChatSendMessageTemplateDTO setMessageBodyToSpecial() {
        return null;
    }

    @Override
    protected String getTemplateId() {
        return null;
    }
}
