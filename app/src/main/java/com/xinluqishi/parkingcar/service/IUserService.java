package com.xinluqishi.parkingcar.service;

import com.xinluqishi.parkingcar.service.util.OnLoginListener;

/**
 * Created by shikeyue on 17/4/5.
 */

public interface IUserService {

    public void login(String username, String password, OnLoginListener loginListener);
}
