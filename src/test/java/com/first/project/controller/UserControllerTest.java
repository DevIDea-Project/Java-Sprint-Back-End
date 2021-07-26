package com.first.project.controller;

import com.first.project.form.LoginForm;
import com.first.project.form.TokenForm;
import com.first.project.form.UserForm;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    private AuthController authController;

    @Test
    @Order(1)
    void creatUser() {

        UserForm newUser = new UserForm();
        newUser.setName("Priscilla Basto");
        newUser.setEmail("priii@gmail.com");
        newUser.setSenha("123456");

        ResponseEntity<UserForm> createUser = userController.createUser(newUser);
        boolean result = createUser.getBody() != null && createUser.getStatusCode() == HttpStatus.CREATED ? true : false;

        assertTrue(result);

    }

    @Test
    @Order(2)
    void toReturn200Sucess() {

        LoginForm login = new LoginForm();
        login.setEmail("priii@gmail.com");
        login.setSenha("123456");

        ResponseEntity<TokenForm> token = authController.authentication(login);
        assertEquals(HttpStatus.OK, token.getStatusCode());

    }

    @Test
    @Order(3)
    void deveriaRetornar400CasoDadosDeAutenticacaoEstejamErrados() {

        LoginForm login = new LoginForm();
        login.setEmail("invalid@gmail.com");
        login.setSenha("123456");

        ResponseEntity<TokenForm> token = authController.authentication(login);

        assertEquals(HttpStatus.BAD_REQUEST, token.getStatusCode());

    }

    @Test
    @Order(4)
    void getListaUsuarios() {
        List<UserForm> usuarioType = userController.listUser();
        boolean result = usuarioType != null && !usuarioType.isEmpty() ? true : false;
        assertTrue(result);
    }

    @Test
    @Order(5)
    void deveDeletarUsuarioComSucesso() throws Exception {
        Integer idUsuario = 1;
        ResponseEntity<UserForm> usuarioDel = userController.deletaUser(idUsuario.longValue());
        assertEquals(HttpStatus.OK, usuarioDel.getStatusCode());
        assertEquals(idUsuario, usuarioDel.getBody().getId().intValue());

    }

    @Test
    @Order(6)
    void deletarUsuarioInexistente() throws Exception {
        Integer idUsuario = 1000;
        ResponseEntity<UserForm> usuarioDel = userController.deletaUser(idUsuario.longValue());
        assertEquals(HttpStatus.NOT_FOUND, usuarioDel.getStatusCode());

    }


}