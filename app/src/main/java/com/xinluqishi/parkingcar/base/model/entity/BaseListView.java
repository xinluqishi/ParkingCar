package com.xinluqishi.parkingcar.base.model.entity;

/**
 * 列表展示基类
 * Created by shikeyue on 17/4/30.
 */

public class BaseListView extends BaseEntity {

    private String title;               //标题
    private String describe;            //描述
    private String imageSrc;            //图片链接

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }
}
