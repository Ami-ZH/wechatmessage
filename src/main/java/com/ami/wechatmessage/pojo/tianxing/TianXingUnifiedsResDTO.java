package com.ami.wechatmessage.pojo.tianxing;

import cn.hutool.json.JSONArray;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 天行API统一返回实体类
 */
@Data
public class TianXingUnifiedsResDTO<T> implements Serializable {

    private Integer code;
    private String msg;
    private List<T> newslist;

}
