package com.ami.wechatmessage.controller;

import com.ami.wechatmessage.enums.ResEnum;
import com.ami.wechatmessage.enums.SendMessageEnum;
import com.ami.wechatmessage.service.template.AbstractSendMessageTemplate;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/sendMessage")
public class SendMessageController {

    @Autowired
    private BeanFactory beanFactory;

    @GetMapping("/now")
    public String sendMessageNow(String messageType){
        SendMessageEnum sendMessageEnum = Arrays.stream(SendMessageEnum.values())
                .filter(item -> item.getTemplate().equals(messageType))
                .findFirst()
                .orElse(null);
        if (sendMessageEnum != null){
            AbstractSendMessageTemplate bean = (AbstractSendMessageTemplate) beanFactory.getBean(sendMessageEnum.getBeanName());
            bean.sendMessage();

            return ResEnum.SUCCESS.getCode();
        }
        return ResEnum.FAILED.getCode();
    }
}
