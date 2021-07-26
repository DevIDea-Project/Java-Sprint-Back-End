//package com.first.project.controller;
//
//import com.first.project.form.UserForm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ActiveProfiles;
//
//import static org.junit.Assert.assertTrue;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@ActiveProfiles("test")
//public class UserControllerTest {
//
//    @Autowired
//    private UserController userController;
//
//    @org.junit.jupiter.api.Test
//    public void creatUser() {
//
//        UserForm newUser = new UserForm();
//        newUser.setName("Priscilla Basto");
//        newUser.setEmail("priii@gmail.com");
//        newUser.setSenha("123456");
//
//        ResponseEntity<UserForm> createUser = userController.createUser(newUser);
//        boolean result = createUser.getBody() != null && createUser.getStatusCode() == HttpStatus.CREATED ? true : false;
//
//        assertTrue(result);
//
//    }
//
////    @org.junit.jupiter.api.Test
////    void getListaUsuarios() {
////        List<UsuarioForm> usuarioType = usuarioController.lista();
////        boolean result = usuarioType != null && !usuarioType.isEmpty() ? true : false;
////        assertTrue(result);
////    }
////
////    @org.junit.jupiter.api.Test
////    void deveDeletarUsuarioComSucesso() throws Exception {
////        Integer idUsuario = 1;
////        ResponseEntity<UsuarioForm> usuarioDel = usuarioController.deleta(idUsuario.longValue());
////        assertEquals(HttpStatus.OK, usuarioDel.getStatusCode());
////        assertEquals(idUsuario, usuarioDel.getBody().getId().intValue());
////
////    }
////
////    @org.junit.jupiter.api.Test
////    void deletarUsuarioInexistente() throws Exception {
////        Integer idUsuario = 1000;
////        ResponseEntity<UsuarioForm> usuarioDel = usuarioController.deleta(idUsuario.longValue());
////        assertEquals(HttpStatus.NOT_FOUND, usuarioDel.getStatusCode());
////
////    }
////
////    @org.junit.jupiter.api.Test
////    void deveInformarErroComUsuarioExistente() {
////        UsuarioExistenteException usuarioException = new UsuarioExistenteException("Usuario Existente");
////        ErrosDeValidacaoControllerAdvice erro = new ErrosDeValidacaoControllerAdvice();
////        ListaDeErrosOutputDto list = erro.capturaUsuarioCadastrado(usuarioException);
////
////        assertEquals(1, list.getQuantidadeDeErros());
////        assertEquals("email", list.getErros().get(0).getParametro());
////        assertEquals("Usuario Existente", list.getErros().get(0).getMensagem());
////
////    }
//
//
//}