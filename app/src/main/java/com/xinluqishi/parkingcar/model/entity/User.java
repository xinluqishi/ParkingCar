package com.xinluqishi.parkingcar.model.entity;

import com.xinluqishi.parkingcar.base.model.entity.BaseEntity;

/**
 * Created by shikeyue on 17/4/5.
 */

public class User extends BaseEntity{

    private static final long serialVersionUID = 1936056658480287561L;

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
