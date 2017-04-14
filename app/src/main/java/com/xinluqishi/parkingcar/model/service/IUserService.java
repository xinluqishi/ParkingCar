package com.xinluqishi.parkingcar.model.service;

import com.xinluqishi.parkingcar.model.service.util.OnLoginListener;

/**
 * Created by shikeyue on 17/4/5.
 */

public interface IUserService {

    public void login(String username, String password, OnLoginListener loginListener);
}
