package io.proyection.projection.Unit.Test;

import io.proyection.projection.domain.User;
import io.proyection.projection.service.UserService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

    @Mock
    private UserService userService;
    @Mock
    private User user;

    @BeforeClass //executes one time and one time only
    public static void inicioClase() {
        System.out.println("Inicio de la clase");
    }


    @AfterClass //when all the test cases have been executed
    public static void finClase() {
        System.out.println("Fin de la clase");
    }

    @Before //Executes each time a method is being called
    public void inicioMetodo() {
        System.out.println("Inicio del método");
    }

    @After //Executes each time after the method was called
    public void despuesMetodo() {
        System.out.println("Despues de cada test");
    }

    @Test
    public void notNullChecker() {
        Assert.assertNotNull(user);
        Assert.assertNotNull(userService);
    }

    @SuppressWarnings("deprecation")
    @Test
    public void insertarUser() {
        try {
            System.out.println("Metodo insertar usuario");

            user = new User();
            user.setUsername("miguel@gmail.com");
            user.setPassword("testing321");
            user.setFirstname("Miguel");
            user.setLastname("Delgado");
            user.setId(1L);

            when(userService.saveUser(any())).thenReturn(user);
            User userObtenido = userService.saveUser(user);

            Assert.assertNotNull(userObtenido);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }

    @Test
    public void getUserById() {
        try {
            System.out.println("Metodo obtener usuario por id");

            User usuarioBuscado;
            user = new User();
            user.setUsername("miguelito@gmail.com");
            user.setPassword("1234567");
            user.setId(2L);

            when(userService.findUserById(any())).thenReturn(user);
            usuarioBuscado = userService.findUserById(2L);
            Assert.assertNotNull(usuarioBuscado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateUser() {
        try {
            User userBuscado;
            User userEditado;

            user = new User();
            user.setUsername("miguelito@gmail.com");
            user.setPassword("1234567");
            user.setId(2L);

            when(userService.findUserById(any())).thenReturn(user);
            userBuscado = userService.findUserById(2L);

            user.setPassword("123456789");
            when(userService.updateUser(any())).thenReturn(user);
            userEditado = userService.updateUser(user);

            Assert.assertEquals(userBuscado.getId(), userEditado.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteUser() {
        try {
            user = new User();
            user.setUsername("miguelito@gmail.com");
            user.setPassword("1234567");
            user.setId(2L);

            boolean userEliminado;

            when(userService.deleteUser(any())).thenReturn(true);
            userEliminado = userService.deleteUser(2L);

            Assert.assertTrue(userEliminado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllUsers() {
        try {
            System.out.println("Metodo obtener todos los usuarios");

            user = new User();
            user.setUsername("miguelito@gmail.com");
            user.setPassword("1234567");
            user.setId(2L);


            List<User> users = new ArrayList<>();
            users.add(user);

            when(userService.findAll()).thenReturn(users);
            List<User> usersObtenidos = (ArrayList<User>) userService.findAll();
            Assert.assertTrue(usersObtenidos.size() > 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
