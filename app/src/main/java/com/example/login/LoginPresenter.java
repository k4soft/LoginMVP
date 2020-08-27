package com.example.login;

public class LoginPresenter implements LoginMVP.Presenter{

    private LoginMVP.Model model;
    private LoginMVP.View view;

    public LoginPresenter(LoginMVP.View view) {
        model = new LoginModel(this);
        this.view = view;
    }

    @Override
    public void rechazarUserName() {
        if(view != null){
            view.rechazarUserName();
        }
    }

    @Override
    public void validarInformacion() {
        if(view != null){
            model.setUserName(view.getTxtUserName());
            model.setPassword(view.getPassword());
            model.validarInformacion();
        }

    }

    @Override
    public void rechazarPassword() {
        if(view != null){
            view.rechazarPassword();
        }
    }

    @Override
    public void rechazarCredenciales() {
        if(view != null){
            view.rechazarCredeciales();
        }
    }

    @Override
    public void aceptarCredenciales() {
        if(view != null){
            view.aceptarCredeciales();
        }
    }
}
