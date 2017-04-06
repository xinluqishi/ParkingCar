package com.xinluqishi.parkingcar.view;

import com.xinluqishi.parkingcar.model.User;

/**
 * Created by shikeyue on 17/4/5.
 */

public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();


    void clearUserName();

    void clearPassword();


}
