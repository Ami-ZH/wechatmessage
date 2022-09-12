package com.ami.wechatmessage.service.gateway.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ami.wechatmessage.constant.WeChatApiUrlConstant;
import com.ami.wechatmessage.pojo.message.WeChatSendMessageTemplateDTO;
import com.ami.wechatmessage.service.gateway.WechatGateWayService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WechatGatewayServiceImpl implements WechatGateWayService {

    @Override
    public String getAccessToken(String appId,String secret) {
        String requestUrl = String.format(WeChatApiUrlConstant.ACCESSTOKEN,appId,secret);
        String resp = HttpUtil.get(requestUrl);
        JSONObject result = JSONUtil.parseObj(resp);
        String token = result.getStr("access_token");
        return token;
    }

    @Override
    public void sendMessage(WeChatSendMessageTemplateDTO message, String token) {
        //请求路径
        String requestUrl = String.format(WeChatApiUrlConstant.SEND_TEMPLATE,token);
        //参数转json
        String json = JSONUtil.parseObj(message).toString();
        String resp = HttpUtil.createPost(requestUrl).body(json).execute().body();
        JSONObject result = JSONUtil.parseObj(resp);
    }

    @Override
    public List<String> getUserList(String token) {
        String requestUrl =  String.format(WeChatApiUrlConstant.USER_LIST,token);
        String resp = HttpUtil.get(requestUrl);
        JSONObject result = JSONUtil.parseObj(resp);
        JSONArray openIdJsonArray = result.getJSONObject("data").getJSONArray("openid");
        List<String> openIds = JSONUtil.toList(openIdJsonArray, String.class);
        return openIds;
    }
}
