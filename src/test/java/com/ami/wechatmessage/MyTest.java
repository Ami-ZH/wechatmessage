package com.ami.wechatmessage;

import com.ami.wechatmessage.enums.SendMessageEnum;
import com.ami.wechatmessage.service.template.impl.GoodMorningSendMessageTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyTest {

    @Autowired
    BeanFactory beanFactory;

    @Test
    public void mytest(){
        GoodMorningSendMessageTemplate template = (GoodMorningSendMessageTemplate) beanFactory.getBean(SendMessageEnum.GOOD_MORNING_MESSAGE.getBeanName());
        template.sendMessage();
    }
}
