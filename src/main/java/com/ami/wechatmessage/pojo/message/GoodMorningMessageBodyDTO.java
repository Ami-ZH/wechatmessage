package com.ami.wechatmessage.pojo.message;

import com.ami.wechatmessage.pojo.WechatTemplateVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 早安消息模板内容
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodMorningMessageBodyDTO extends BaseMessageBodyDTO {
    private WechatTemplateVO morning;
    private WechatTemplateVO date;
    private WechatTemplateVO week;
    private WechatTemplateVO city;
    private WechatTemplateVO weather;
    private WechatTemplateVO lowest;
    private WechatTemplateVO highest;
    private WechatTemplateVO pop;
    private WechatTemplateVO tips;
    private WechatTemplateVO pipi;
}
