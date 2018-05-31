package com.inredec.atutor.presentatiolayer.controllers.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.inredec.atutor.R;
import com.inredec.atutor.model.businesslayer.entities.User;
import com.inredec.atutor.model.servicelayer.manager.ServiceManager;
import com.inredec.atutor.presentatiolayer.controllers.androidextends.ATutorApplication;
import com.inredec.atutor.utilitieslayer.AppUtils;

import java.text.ParseException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity {

    //GUI objects
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_mail)
    EditText etMail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.bt_register)
    Button btRegister;

    EditText t1;

    private static final String TAG = "TestActivity";

    //Service
    private ServiceManager serviceManager = null;

    //My Application
    private ATutorApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        /*
        serviceManager = new ServiceManager(this);
        try {
            serviceManager.getUserServices().createInitialLocalUsers();
        } catch (ParseException e) {
            e.printStackTrace();
        }
*/


        t1 = (EditText)findViewById(R.id.et_name);
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((etName.getText().toString().isEmpty()) || (etPassword.getText().toString().isEmpty())) {
                    if (etName.getText().toString().isEmpty()) Toast.makeText(TestActivity.this,
                            "Correo no puede ser nulo",
                            Toast.LENGTH_SHORT).show();
                    else Toast.makeText(TestActivity.this,
                            "Contraseña no puede ser nulo",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(TestActivity.this,
                            "Campos correo/pass rellenados",
                            Toast.LENGTH_SHORT).show();
                    // Cambiar activity
                    Intent myIntent = new Intent(TestActivity.this, TestActivity.class);
                    //Bundle extras = myIntent.getExtras();
                 //   extras.putString("etUsernameValue" , String.valueOf(t1.getText()));
                    myIntent.putExtra("etUsernameValue", etName.getText().toString().toString());
                    myIntent.putExtra("etMail", etMail.getText().toString());
                    myIntent.putExtra("etPassword", etPassword.getText().toString().toString());
                    //todo start new Activity
                    Log.d(TAG, "TestActivity etName value: " +  etName.getText().toString().toString());
                    Log.d(TAG, "TestActivity etName value: " +  etMail.getText().toString().toString());
                    Log.d(TAG, "TestActivity etName value: " +  etPassword.getText().toString().toString());
                    saveUser();
                    //Intent myIntent2 = new Intent(TestActivity.this, AddUserTestActivity.class);
                   // startActivity(myIntent2);
                }
            }
        });

    }


    private void saveUser(){
        User user = new User(etName.getText().toString().toString().trim(),
                etMail.getText().toString().toString().toString().trim(),
                etPassword.getText().toString().toString().trim());
        Log.d(TAG, "TestActivity.saveUser() " + user);
        // Save user to JSON flat file
        //List<User> users = serviceManager.getUserServices().getAllusers();
        /*for(User usr: users){
            Log.d(TAG, "TestActivity - saveUser()"+ usr);
        }*/
       //serviceManager.getUserServices().saveUser(user, AppUtils.PersistenceTechnologies.FLAT_FILE);
    }


}
