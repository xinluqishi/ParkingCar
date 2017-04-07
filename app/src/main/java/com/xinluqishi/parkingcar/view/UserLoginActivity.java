package com.xinluqishi.parkingcar.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.xinluqishi.parkingcar.R;
import com.xinluqishi.parkingcar.model.User;
import com.xinluqishi.parkingcar.presenter.UserLoginPresenter;

/**
 * Created by shikeyue on 17/4/5.
 */

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView {

    private EditText editTextUsername, editTextPassword;

    private Button btnLogin, btnClear;

    private ProgressBar progressBar;

    private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initLoginView();
    }

    private void initLoginView() {

        editTextUsername = (EditText) findViewById(R.id.login_edit_username);
        editTextPassword = (EditText) findViewById(R.id.login_edit_password);

        btnLogin = (Button) findViewById(R.id.login_btn_login);
        btnClear = (Button) findViewById(R.id.login_btn_clear);

        progressBar = (ProgressBar) findViewById(R.id.pb_loading);

    }

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
