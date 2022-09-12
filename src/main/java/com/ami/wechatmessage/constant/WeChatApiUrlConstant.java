package com.ami.wechatmessage.constant;

public interface WeChatApiUrlConstant {

    // 微信公众号获取统一token
    String ACCESSTOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    //微信推送模板消息
    String SEND_TEMPLATE = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s";

    //获取关注用户信息
    String USER_LIST = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=%s";
}
