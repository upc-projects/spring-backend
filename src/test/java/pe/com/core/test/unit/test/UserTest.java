package pe.com.core.test.unit.test;

import io.proyection.projection.domain.User;
import io.proyection.projection.service.UserService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Sort;

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
}
