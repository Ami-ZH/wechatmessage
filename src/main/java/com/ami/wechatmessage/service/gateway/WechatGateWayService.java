package com.ami.wechatmessage.service.gateway;

import com.ami.wechatmessage.pojo.message.WeChatSendMessageTemplateDTO;

import java.util.List;

public interface WechatGateWayService {

    String getAccessToken(String appId,String secret);

    void sendMessage(WeChatSendMessageTemplateDTO message, String token);

    List<String> getUserList(String token);

}
