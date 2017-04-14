package com.xinluqishi.parkingcar.model.service.util;

import com.xinluqishi.parkingcar.model.entity.User;

/**
 * Created by shikeyue on 17/4/5.
 */
public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();

}
