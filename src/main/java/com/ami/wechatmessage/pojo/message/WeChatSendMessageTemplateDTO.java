package com.ami.wechatmessage.pojo.message;

import lombok.Data;

@Data
public class WeChatSendMessageTemplateDTO<T> {
    private String template_id;
    private String touser;
    private BaseMessageBodyDTO data;
}
