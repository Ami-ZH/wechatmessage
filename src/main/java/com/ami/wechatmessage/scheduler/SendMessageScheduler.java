package com.ami.wechatmessage.scheduler;

import com.ami.wechatmessage.enums.SendMessageEnum;
import com.ami.wechatmessage.service.template.impl.GoodMorningSendMessageTemplate;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SendMessageScheduler {

    private BeanFactory beanFactory;

    @Scheduled(cron = "0 0 7 * * ?")
    public void sendGoodMorningMessage(){
        GoodMorningSendMessageTemplate template = (GoodMorningSendMessageTemplate) beanFactory.getBean(SendMessageEnum.GOOD_MORNING_MESSAGE.getBeanName());
        template.sendMessage();
    }

    public void sendGoodNightMessage(){

    }

    public void sendDrinkWaterMessage(){

    }
}
