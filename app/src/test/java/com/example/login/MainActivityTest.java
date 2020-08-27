package com.example.login;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityTest {

    @Mock
    LoginMVP.View view;
    LoginMVP.Presenter presenter;
    LoginMVP.Model model;


    @Before
    public void setUp(){
        presenter = new LoginPresenter(view);
        model = new LoginModel(presenter);
    }

    @Test
    public void nombreUsuarioRequerido(){
        when(view.getTxtUserName()).thenReturn("");
        model.setUserName(view.getTxtUserName());
        model.validarInformacion();
        verify(view).rechazarUserName();
    }

    @Test
    public void paswwardReuquerido(){
        when(view.getPassword()).thenReturn("");
        model.setPassword(view.getPassword());
        model.validarInformacion();
        verify(view).rechazarPassword();
    }

    @Test
    public void rechazarCrediciales(){
        when(view.getTxtUserName()).thenReturn("prueba");
        when(view.getPassword()).thenReturn("1234");
        model.setUserName(view.getTxtUserName());
        model.setPassword(view.getPassword());
        model.validarInformacion();
        verify(view).rechazarCredeciales();
    }

    @Test
    public void aceptarCrediciales(){
        when(view.getTxtUserName()).thenReturn("pruebas");
        when(view.getPassword()).thenReturn("1234");
        model.setUserName(view.getTxtUserName());
        model.setPassword(view.getPassword());
        model.validarInformacion();
        verify(view).aceptarCredeciales();
    }




}