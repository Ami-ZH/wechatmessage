package com.ami.wechatmessage.service.template;

import com.ami.wechatmessage.config.TianXingConfig;
import com.ami.wechatmessage.config.WechatConfig;
import com.ami.wechatmessage.enums.SpecialOpenIdEnum;
import com.ami.wechatmessage.pojo.message.WeChatSendMessageTemplateDTO;
import com.ami.wechatmessage.service.gateway.WechatGateWayService;

import java.util.List;

public abstract class AbstractSendMessageTemplate {

    protected final TianXingConfig tianXingConfig;
    protected final WechatConfig wechatConfig;
    private final WechatGateWayService wechatGateWayService;

    public AbstractSendMessageTemplate(TianXingConfig tianXingConfig, WechatConfig wechatConfig,
                                       WechatGateWayService wechatGateWayService) {
        this.tianXingConfig = tianXingConfig;
        this.wechatConfig = wechatConfig;
        this.wechatGateWayService = wechatGateWayService;
    }

    /**
     * 获取微信公众号token
     * @return
     */
    private String getWechatAccessToken(){
        return wechatGateWayService.getAccessToken(wechatConfig.getAppId(),wechatConfig.getAppSecert());
    }

    /**
     * 子类根据不同的微信模板消息内容自行实现
     * @return
     */
    protected abstract WeChatSendMessageTemplateDTO setMessageBody(String templateId, String openId);


    /**
     * 子类根据不同的微信模板消息内容自行实现
     * @return
     */
    protected abstract WeChatSendMessageTemplateDTO setMessageBodyToSpecial();

    /**
     * 获取公众号的模板Id；
     * @return
     */
    protected abstract String getTemplateId();

    /**
     * 获取微信公众号关注的用户OpenId
     * @param token
     * @return
     */
    private List<String> getUserList(String token){
        return wechatGateWayService.getUserList(token);
    }

    /**
     * 公众号向所有用户发送消息
     */
    public void sendMessage(){
        String token = getWechatAccessToken();
        List<String> userList = getUserList(token);
        for (String openId : userList){
            String templateId = getTemplateId();
            WeChatSendMessageTemplateDTO message = setMessageBody(templateId,openId);
            wechatGateWayService.sendMessage(message,token);
        }
    }

    /**
     * 公众号向特殊的用户发送消息,需要先将用户的OpengId获取放到枚举中
     */
    public void sendMessageToSpecial(){
        String token = getWechatAccessToken();
        WeChatSendMessageTemplateDTO message = setMessageBodyToSpecial();
        wechatGateWayService.sendMessage(message,token);
    }
}
