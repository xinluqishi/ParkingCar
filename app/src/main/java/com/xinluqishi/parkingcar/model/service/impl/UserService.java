package com.xinluqishi.parkingcar.model.service.impl;

import com.xinluqishi.parkingcar.model.entity.User;
import com.xinluqishi.parkingcar.model.service.IUserService;
import com.xinluqishi.parkingcar.model.service.util.OnLoginListener;

/**
 * Created by shikeyue on 17/4/5.
 */

public class UserService implements IUserService{


    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if ("shikeyue".equals(username) && "123".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
