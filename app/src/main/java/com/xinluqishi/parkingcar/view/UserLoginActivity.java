package com.xinluqishi.parkingcar.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.xinluqishi.parkingcar.R;
import com.xinluqishi.parkingcar.model.entity.User;
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

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.login();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.clear();
            }
        });

    }

    @Override
    public String getUserName() {
        return editTextUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return editTextPassword.getText().toString();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainAppActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUserName() {
        editTextUsername.setText("");
    }

    @Override
    public void clearPassword() {
        editTextPassword.setText("");
    }
}
