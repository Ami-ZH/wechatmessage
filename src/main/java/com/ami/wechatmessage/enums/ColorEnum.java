package com.ami.wechatmessage.enums;

public enum ColorEnum {

    BLACK("","黑色"),
    BLUE("#A4D3EE","蓝色"),
    RED("#ff6666","红色"),
    PURPLE("#9900ff","紫色"),
    ORANGE("#FF7F24","橙色"),
    BROWN("#CD96CD","棕色"),
    DARK_RED("#CD3333","暗红色"),
    LAVENDER("#E066FF","淡紫色"),
    ;

    private String color;
    private String desc;

    ColorEnum(String color, String desc) {
        this.color = color;
        this.desc = desc;
    }

    public String getColor() {
        return color;
    }
}
