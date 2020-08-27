package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.welcome.WelcomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LoginMVP.View{

    @BindView(R.id.txtUserName)
    public EditText txtUserName;
    @BindView(R.id.txtPassword)
    public EditText txtPassword;
    @BindView(R.id.btnAceptar)
    public Button btnAceptar;

    private LoginMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this);
    }


    @Override
    public String getTxtUserName() {
        return txtUserName.getText().toString();
    }

    @Override
    public void rechazarUserName() {
        txtUserName.setError(getString(R.string.requerido));
    }

    @Override
    public String getPassword() {
        return txtPassword.getText().toString();
    }

    @Override
    public void rechazarPassword() {
        txtPassword.setError(getString(R.string.requerido));
    }

    @Override
    public void rechazarCredeciales() {
        Toast.makeText(getApplicationContext(),R.string.credenciales_no_validas, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void aceptarCredeciales() {
        Toast.makeText(getApplicationContext(),R.string.bienvenido, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
        startActivity(intent);
    }

    public void validarInformacion(View view) {
        presenter.validarInformacion();
    }
}