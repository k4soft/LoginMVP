package com.example.login;

public class LoginModel implements LoginMVP.Model{

    private final LoginMVP.Presenter presenter;
    private String userName;
    private String password;

    public LoginModel(LoginMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void validarInformacion() {
        if("".equals(userName)){
            presenter.rechazarUserName();
        }

        if("".equals(password)){
            presenter.rechazarPassword();
        }

        if("pruebas".equals(userName) && "1234".equals(password)){
            presenter.aceptarCredenciales();
        }else{
            presenter.rechazarCredenciales();
        }
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
