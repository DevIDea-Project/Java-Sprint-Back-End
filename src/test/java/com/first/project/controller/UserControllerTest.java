package com.first.project.controller;

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
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    @Order(1)
    public void creatUser() {

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
    void getListaUsuarios() {
        List<UserForm> usuarioType = userController.listUser();
        boolean result = usuarioType != null && !usuarioType.isEmpty() ? true : false;
        assertTrue(result);
    }

    @Test
    @Order(3)
    void deveDeletarUsuarioComSucesso() throws Exception {
        Integer idUsuario = 1;
        ResponseEntity<UserForm> usuarioDel = userController.deletaUser(idUsuario.longValue());
        assertEquals(HttpStatus.OK, usuarioDel.getStatusCode());
        assertEquals(idUsuario, usuarioDel.getBody().getId().intValue());

    }

    @Test
    @Order(4)
    void deletarUsuarioInexistente() throws Exception {
        Integer idUsuario = 1000;
        ResponseEntity<UserForm> usuarioDel = userController.deletaUser(idUsuario.longValue());
        assertEquals(HttpStatus.NOT_FOUND, usuarioDel.getStatusCode());

    }


}