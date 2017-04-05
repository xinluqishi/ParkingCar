package com.xinluqishi.parkingcar.service.util;

import com.xinluqishi.parkingcar.model.User;

/**
 * Created by shikeyue on 17/4/5.
 */
public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();

}
