package com.example.login;

public interface LoginMVP {

    public interface View{
        String getTxtUserName();

        void rechazarUserName();

        String getPassword();

        void rechazarPassword();

        void rechazarCredeciales();

        void aceptarCredeciales();
    }

    public interface Presenter{

        void rechazarUserName();

        void validarInformacion();

        void rechazarPassword();

        void rechazarCredenciales();

        void aceptarCredenciales();
    }

    public interface Model{

        void setUserName(String userName);

        void validarInformacion();

        void setPassword(String password);
    }


}
