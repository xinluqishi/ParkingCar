package com.xinluqishi.parkingcar.base.model.entity;

/**
 * 接收Api返回值
 * Created by shikeyue on 2017/4/13.
 */
public class ApiResult<T>{

    private int code;//代码
    private String message;//信息
//    @JsonAdapter(ContentTypeAdapterFactory.class)
    T content;//内容可变

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
