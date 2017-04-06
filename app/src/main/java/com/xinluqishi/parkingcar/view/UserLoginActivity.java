package com.xinluqishi.parkingcar.view;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.xinluqishi.parkingcar.model.User;

/**
 * Created by shikeyue on 17/4/5.
 */

public class UserLoginActivity extends AppCompatActivity implements ILoginView {

    private EditText editTextUsername, editTextPassword;

    private Button btnLogin, btnClear;

    private ProgressBar progressBar;


    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainActivity(User user) {

    }

    @Override
    public void showFailedError() {

    }

    @Override
    public void clearUserName() {

    }

    @Override
    public void clearPassword() {

    }
}
