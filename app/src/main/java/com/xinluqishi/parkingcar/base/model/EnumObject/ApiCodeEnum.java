package com.xinluqishi.parkingcar.base.model.EnumObject;

/**
 * 返回值状态码
 */
public enum ApiCodeEnum {

    SUCCESS(100),//成功
    USERNAME_OR_PASSWORD_ERROR(1001),//用户名或密码错误
    USER_NOT_FOUND(1002),//用户不存在
    USER_NOT_LOGIN(1003),//用户未登录
    USERNAME_IS_NULL(1004),//用户名错误
    PASSWORD_IS_NULL(1005),//密码错误
    VERIFYCODE_IS_NULL(1006),//验证码错误
    FLIGHT_SEARCH_ERROR(1101),//机票查询异常
    CLOGIN_ERR(1023);//企业尚未绑定个人用户

    private int code;

    private ApiCodeEnum(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
