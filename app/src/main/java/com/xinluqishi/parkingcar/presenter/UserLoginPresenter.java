package com.xinluqishi.parkingcar.presenter;

import android.os.Handler;

import com.xinluqishi.parkingcar.model.entity.User;
import com.xinluqishi.parkingcar.model.service.IUserService;
import com.xinluqishi.parkingcar.model.service.impl.UserService;
import com.xinluqishi.parkingcar.model.service.util.OnLoginListener;
import com.xinluqishi.parkingcar.view.IUserLoginView;


/**
 * Created by shikeyue on 17/4/6.
 */

public class UserLoginPresenter {

    private IUserService userService;

    private IUserLoginView userLoginView;

    private Handler handler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userService = new UserService();
    }

    public void login() {
        userLoginView.showLoading();
        userService.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }

}
