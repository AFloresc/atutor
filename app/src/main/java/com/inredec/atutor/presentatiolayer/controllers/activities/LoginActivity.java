package com.inredec.atutor.presentatiolayer.controllers.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.inredec.atutor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.cb_remember)
    CheckBox cbRemember;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.bt_register)
    Button btRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        //Hide keyboard on initial focus
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((etUsername.getText().toString().isEmpty()) || (etPassword.getText().toString().isEmpty())) {
                        if (etUsername.getText().toString().isEmpty()) Toast.makeText(LoginActivity.this,
                                "Correo no puede ser nulo",
                                Toast.LENGTH_SHORT).show();
                        else Toast.makeText(LoginActivity.this,
                                "Contraseña no puede ser nulo",
                                Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(LoginActivity.this,
                            "Campos correo/pass rellenados",
                            Toast.LENGTH_SHORT).show();
                    // Cambiar activity
                    Intent myIntent = new Intent(LoginActivity.this, MainAppActivity.class);
                    //Bundle extras = myIntent.getExtras();
                    startActivity(myIntent);
                    ///extras.putString("etUsernameValue", etUsername.getText().toString().trim());
                    //extras.putString("etValue", etUsername.getText().toString().trim());
                    //todo start new Activity

                }
            }
        });

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(LoginActivity.this, TestActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
