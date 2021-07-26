package com.first.project.controller;

import com.first.project.form.LoginForm;
import com.first.project.form.TokenForm;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthControllerTest {

    @Autowired
    private AuthController authController;

    @Test
    public void deveriaRetornar400CasoDadosDeAutenticacaoEstejamErrados() {

        LoginForm login = new LoginForm();
        login.setEmail("invalid@gmail.com");
        login.setSenha("123456");

        ResponseEntity<TokenForm> token = authController.authentication(login);

        assertEquals(HttpStatus.BAD_REQUEST, token.getStatusCode());

    }


    @Test
    public void toReturn200Sucess() {

        LoginForm login = new LoginForm();
        login.setEmail("priii@gmail.com");
        login.setSenha("123456");

        ResponseEntity<TokenForm> token = authController.authentication(login);
        System.out.println("Result -> " + token);

        assertEquals(HttpStatus.OK, token.getStatusCode());

    }

}